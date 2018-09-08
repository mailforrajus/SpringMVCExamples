package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.nt.dao","com.nt.service"})
public class BusinessConfig {
	
	@Bean
	public DataSource createDataSource(){
		DriverManagerDataSource drds=null;
		drds=new DriverManagerDataSource();
		drds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		drds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		drds.setUsername("system");
		drds.setPassword("manager");
		return drds;
	}

}
