package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="cpds")
	public DataSource createDataSource()throws Exception{
		ComboPooledDataSource cpds=null;
		cpds=new ComboPooledDataSource();
		cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("system");
		cpds.setPassword("manager");
		return cpds;
	}
	
	@Bean(name="template")
	public  JdbcTemplate createJdbcTemplate()throws Exception{
		return new JdbcTemplate(createDataSource());
	}
	

}
