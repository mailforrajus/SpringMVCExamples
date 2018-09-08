package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//crreate IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("pfb",ShoppingStore.class);
		//invoke method
		System.out.println("Bill amount:::"+proxy.generateBillAmount(new String[]{"pathani","cap","cent","kheer","Biryani","fruits","cookdrinks"} ));
		
		((AbstractApplicationContext) ctx).close();
	}//method
}//class
