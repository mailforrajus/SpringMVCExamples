package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"com.nt.service","com.nt.advice"})
@EnableAspectJAutoProxy
public class AppConfig {
	

}
