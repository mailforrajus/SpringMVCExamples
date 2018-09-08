package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ArithmeticService;

public class AnnoAllAspectsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("arithService",ArithmeticService.class);
		//invoke methods
		System.out.println("sum==="+proxy.sum(10, 20));
		System.out.println("------------------------------------");
		System.out.println("sub==="+proxy.sub(10, 20));
		System.out.println("------------------------------------");
		System.out.println("mul==="+proxy.mul(10, 20));
		System.out.println("------------------------------------");
		System.out.println("div==="+proxy.div(10,0));
		System.out.println("------------------------------------");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}
