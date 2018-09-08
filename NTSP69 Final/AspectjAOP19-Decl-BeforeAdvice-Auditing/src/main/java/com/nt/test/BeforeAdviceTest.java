package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
	   //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke method
		System.out.println(proxy.approveLoan(1001, "raja",80000));
	   System.out.println("........................................");
		System.out.println(proxy.approveLoan(1001, "raja",-8000));
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
