package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="hikariDs")
	public DataSource createDataSource(){
		HikariDataSource hds=null;
		hds=new HikariDataSource();
		hds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hds.setUsername("system");
		hds.setPassword("manager");
		return hds;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJdbcTemplate(){
		return  new JdbcTemplate(createDataSource());
	}

}
