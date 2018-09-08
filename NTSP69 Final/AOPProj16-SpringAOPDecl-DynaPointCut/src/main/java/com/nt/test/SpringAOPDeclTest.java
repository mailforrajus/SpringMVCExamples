package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.AirthmeticOperationsService;

public class SpringAOPDeclTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticOperationsService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("pfb",AirthmeticOperationsService.class);
		
		//invoke methods
		System.out.println("sum ====>"+proxy.sum(1000,2000));
		System.out.println("-------------------------------------------------");
		System.out.println("sum ====>"+proxy.sum(10,20));
		System.out.println("-------------------------------------------------");
		System.out.println("sub ====>"+proxy.sub(1000,2000));
		System.out.println("-------------------------------------------------");
		System.out.println("mul ====>"+proxy.mul(2000,1000));
		System.out.println("-------------------------------------------------");
		System.out.println("Div ====>"+proxy.div(4000,2000));
		System.out.println("-------------------------------------------------");
		//close container
		((AbstractApplicationContext) ctx).close();
	}//method
}//class
