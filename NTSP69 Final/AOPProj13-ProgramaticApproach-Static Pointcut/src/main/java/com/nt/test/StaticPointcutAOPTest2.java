package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperationsService;

public class StaticPointcutAOPTest2 {

	public static void main(String[] args) {
		AirthmeticOperationsService service=null,proxy=null;
		PerformanceMonitoringAdvice advice=null;
		ProxyFactory factory=null;
		NameMatchMethodPointcutAdvisor advisor1=null;
		
	   //create Target /service class obj
		service=new AirthmeticOperationsService();
		//create Advice class object
		advice=new PerformanceMonitoringAdvice();
		//create Advisor which is having Pointcut internally
		advisor1=new NameMatchMethodPointcutAdvisor();
		advisor1.setAdvice(advice);
		advisor1.setMappedNames("mul","sum");
		
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
		System.out.println("Div===>"+proxy.div(10,20));
		System.out.println("...........................................");
		
		
		
	}//method
}//class
