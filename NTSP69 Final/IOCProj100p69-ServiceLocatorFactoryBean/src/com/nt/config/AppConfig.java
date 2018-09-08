package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.nt.service","com.nt.serviceLocator"})
public class AppConfig {
	static{
		System.out.println("AppConfig:static block");
	}
	public AppConfig() {
		System.out.println("AppConfig:0-param constructor");
	}
	
	

}
