package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
@EnableWebMvc
public class WebMVCAppConfig {

	@Bean
	public  HandlerMapping createSUHMapping() {
		 SimpleUrlHandlerMapping suhm=null;
		 Properties mappings=null;
		 suhm=new SimpleUrlHandlerMapping();
		 mappings=new Properties();
		 mappings.put("/home.htm", "pvc");
		 mappings.put("/access_fail.htm", "pvc1");
		 mappings.put("/logout.htm", "pvc2");
		 suhm.setMappings(mappings);
		 return suhm;
	}
	
	@Bean(name="pvc")
	public  Controller  createPVC() {
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("home");
		return pvc;
	}
	
	@Bean(name="pvc1")
	public  Controller  createPVC1() {
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("access_fail");
		return pvc;
	}
	
	@Bean(name="pvc2")
	public  Controller  createPVC2() {
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("my_logout");
		return pvc;
	}
	
	
	@Bean
	public ViewResolver createIRViewResolver() {
		  InternalResourceViewResolver resolver=null;
		  resolver=new InternalResourceViewResolver();
		  resolver.setPrefix("/WEB-INF/pages/");
		  resolver.setSuffix(".jsp");
		  return resolver;
	}
	
}
