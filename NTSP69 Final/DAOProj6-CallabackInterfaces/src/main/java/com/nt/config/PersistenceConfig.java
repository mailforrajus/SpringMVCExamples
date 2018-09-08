package com.nt.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")

public class PersistenceConfig {
	
	
	/*@Bean(name="c3P0Ds")
	public  DataSource createDataSource() throws Exception{
		ComboPooledDataSource cpDs;
		cpDs=new ComboPooledDataSource();
		cpDs.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpDs.setUser("system");
		cpDs.setPassword("manager");
		return cpDs;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJTemplate()throws Exception{
		return new JdbcTemplate(createDataSource());
	}
	
	*/
	
	
	
	
}
