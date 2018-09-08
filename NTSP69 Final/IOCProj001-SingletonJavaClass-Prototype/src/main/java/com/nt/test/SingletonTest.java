package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PrinterUtil;

public class SingletonTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PrinterUtil util1=null,util2=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		util1=ctx.getBean("pu",PrinterUtil.class);
		System.out.println(util1);
		
		util2=ctx.getBean("pu",PrinterUtil.class);
		System.out.println(util2);
		
		//close container
		((AbstractApplicationContext) ctx).close();
		}//main
}//class
