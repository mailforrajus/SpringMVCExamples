package com.nt.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.beans")
public class AppConfig {
	
static{
	System.out.println("AppConfig:static block");
}
	
	@Bean(name="cal")
	public Calendar createCalendar(){
		System.out.println("AppConfig:createCalendar()");
		return Calendar.getInstance();
	}

}
