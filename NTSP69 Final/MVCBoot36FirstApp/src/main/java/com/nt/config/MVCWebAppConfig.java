package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class MVCWebAppConfig {

	public MVCWebAppConfig() {
		System.out.println("MVCWebAppConfig.MVCWebAppConfig()");
	}
	
}
