package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="c3p0Ds")
	public  DataSource createDs()throws Exception{
		ComboPooledDataSource c3p0Ds=null;
		c3p0Ds=new ComboPooledDataSource();
		c3p0Ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		c3p0Ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		c3p0Ds.setUser("system");
		c3p0Ds.setPassword("manager");
		return c3p0Ds;
	}
	
	@Bean
	public  SimpleJdbcInsert createSJInsert() throws Exception{
		return new SimpleJdbcInsert(createDs());
	}

}
