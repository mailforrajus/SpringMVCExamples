package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class BootAspectJaopProj25AroundAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		ctx=SpringApplication.run(BootAspectJaopProj25AroundAdviceApplication.class, args);
		//get Proxy obj
		 proxy=ctx.getBean("bankService",BankService.class);
		 //invoke methods
		 System.out.println("Simple Intr Amount:::"+proxy.calcSimpleIntrAmount(10000,2,20));
		 System.out.println("...............................");
		 System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(10000, 2, 20));
		 
		 System.out.println("class name"+proxy.getClass());
		 //close container
		 ((AbstractApplicationContext) ctx).close();
		 
	}//main
}//class
