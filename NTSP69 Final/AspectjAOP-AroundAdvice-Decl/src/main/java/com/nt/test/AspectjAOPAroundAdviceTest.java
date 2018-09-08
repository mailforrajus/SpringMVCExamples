package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AspectjAOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container 
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		 proxy=ctx.getBean("bankService",BankService.class);
		 //invoke methods
		 System.out.println("Simple Intr Amount:::"+proxy.calcSimpleIntrAmount(10000,2,20));
		 System.out.println("...............................");
		 System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(10000, 0, 20));
		 
		 System.out.println("class name"+proxy.getClass());
		 //close container
		 ((AbstractApplicationContext) ctx).close();
		 

	}

}
