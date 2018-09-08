package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.pointcut.MyDynaPointcut1;
import com.nt.service.AirthmeticOperationsService;

public class DynaPointcutAOPTest {

	public static void main(String[] args) {
		AirthmeticOperationsService service=null,proxy=null;
		PerformanceMonitoringAdvice advice=null;
		MyDynaPointcut1 ptc1=null;
		ProxyFactory factory=null;
		DefaultPointcutAdvisor advisor1=null;
		
	   //create Target /service class obj
		service=new AirthmeticOperationsService();
		//create Advice class object
		advice=new PerformanceMonitoringAdvice();
		//create Pointcut class obj
		ptc1=new MyDynaPointcut1();
		//create Advisor
		advisor1=new DefaultPointcutAdvisor(ptc1,advice);
		
		//create ProxyFactory
		factory=new ProxyFactory();
		//set target 
		factory.setTarget(service);
		/*
		factory.addAdvice(advice);*/
		// add advisor
		factory.addAdvisor(advisor1);
		//get Proxy object
		proxy=(AirthmeticOperationsService)factory.getProxy();
		//invoke the method
		System.out.println("Sum===>"+proxy.sum(10,20));
		System.out.println("...........................................");
		System.out.println("Sub===>"+proxy.sub(10,20));
		System.out.println("...........................................");
		System.out.println("Mul===>"+proxy.mul(10,20));
		System.out.println("...........................................");
		System.out.println("Mul===>"+proxy.mul(1100,1200));
		System.out.println("...........................................");
		System.out.println("Div===>"+proxy.div(10,20));
		System.out.println("...........................................");
		
		
		
	}//method
}//class
