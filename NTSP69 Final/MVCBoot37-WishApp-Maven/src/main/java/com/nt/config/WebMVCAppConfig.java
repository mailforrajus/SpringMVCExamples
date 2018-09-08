package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class WebMVCAppConfig {
	
	@Bean
	public HandlerMapping createSUHMapping(){
		System.out.println("WebMVCAppConfig.createSUHMapping()");
		SimpleUrlHandlerMapping mapping=null;
		Properties props=null;
		mapping=new SimpleUrlHandlerMapping();
		props=new Properties();
		props.put("home.htm","pvc");
		mapping.setMappings(props);
		mapping.setOrder(65535);
		return mapping;
	}
	
	@Bean(name="pvc")
	public ParameterizableViewController createPVC(){
		System.out.println("WebMVCAppConfig.createPVC()");
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("welcome");
		return pvc;
	}

}
