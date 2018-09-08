package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.CollegeService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class IocBootApp73BppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CollegeService service=null;
		//get IOC container
		ctx=SpringApplication.run(IocBootApp73BppApplication.class, args);
		//get bean
		service=ctx.getBean("clgService",CollegeService.class);
		//invoke methods
		service.registerStudent(101,"raja", "java");
		service.registerEmployee(999,"ramesh","clerk");
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}
}
