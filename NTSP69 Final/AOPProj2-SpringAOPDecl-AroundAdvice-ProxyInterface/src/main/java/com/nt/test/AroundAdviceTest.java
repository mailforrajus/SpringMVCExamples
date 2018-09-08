package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankServiceImpl;
import com.nt.service.IBankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService proxy=null;
				//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get PRoxy class object
		proxy=ctx.getBean("pfb",IBankService.class);
		//invoke method on proxy object
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(50000, 2,12));
		System.out.println("................................................");
		System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrAmount(50000, 2,12));
		System.out.println("---------------------");
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(50000, 2,12));
		System.out.println("................................................");
		System.out.println("proxy obj class name::"+proxy.getClass()+"-->"+proxy.getClass().getSuperclass()+" -->"+Arrays.toString(proxy.getClass().getInterfaces()));
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
