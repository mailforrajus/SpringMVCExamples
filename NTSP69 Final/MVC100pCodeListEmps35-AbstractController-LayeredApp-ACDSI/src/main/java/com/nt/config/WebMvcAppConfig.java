package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class WebMvcAppConfig {
	
	@Bean
	public  HandlerMapping  createSUHM(){
		SimpleUrlHandlerMapping mapping=null;
		Properties  props=null;
		mapping=new SimpleUrlHandlerMapping();
		props=new Properties();
		props.put("/home.htm", "pvc");
		mapping.setMappings(props);
		return mapping;
	}
	
	@Bean
	public   HandlerMapping createRMHM(){
		   return new RequestMappingHandlerMapping();
	}
	
	@Bean(name="pvc")
	public  Controller  createPVC(){
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("welcome");
		return pvc;
	}
	
	
	
	@Bean
	public  ViewResolver  createIVR(){
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		return ivr;
	}

}
