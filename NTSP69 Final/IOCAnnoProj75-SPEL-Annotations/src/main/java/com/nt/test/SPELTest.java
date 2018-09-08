package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.UberEats;

public class SPELTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		UberEats eats=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		eats=ctx.getBean("uberEats",UberEats.class);
		System.out.println(eats);
		//close container
		((AbstractApplicationContext) ctx).close();
			}

}
