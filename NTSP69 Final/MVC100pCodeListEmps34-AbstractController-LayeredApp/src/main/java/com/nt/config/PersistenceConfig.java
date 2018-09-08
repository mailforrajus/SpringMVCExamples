package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
@PropertySource(value="classpath:com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	/*@Bean
	public  JndiObjectFactoryBean createJOFB(){
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}*/
	
	/*@Bean
	public DataSource createJDSL(){
		JndiDataSourceLookup jdsl=null;
		DataSource ds=null;
		jdsl=new JndiDataSourceLookup();
		ds=jdsl.getDataSource("java:/comp/env/DsJndi");
		return ds;
		
	}*/
	
	@Bean
	public  DataSource   createApacheDBCPDS(){
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		/*bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");*/
		
		bds.setDriverClassName(env.getProperty("jdbc.driver"));
		bds.setUrl(env.getProperty("jdbc.url"));
		bds.setUsername(env.getProperty("jdbc.user"));
		bds.setPassword(env.getProperty("jdbc.pwd"));
		return bds;
	}
	
/*	@Bean
       @Primary
	public  DataSource   createDataSource(){
		DataSource ds=null;
		ds=(DataSource) createJOFB().getObject();
		return ds;
	}
*/	
	@Bean
	public  JdbcTemplate createJT(){
		JdbcTemplate jt=null;
		//jt=new JdbcTemplate(createDataSource());
		//jt=new JdbcTemplate((DataSource)createJOFB().getObject());
		//jt=new JdbcTemplate(createJDSL());
		jt=new JdbcTemplate(createApacheDBCPDS());
		return jt;
	}

}
