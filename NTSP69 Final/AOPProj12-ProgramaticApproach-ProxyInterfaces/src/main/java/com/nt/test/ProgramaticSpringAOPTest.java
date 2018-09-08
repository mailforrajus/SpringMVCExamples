package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.PerformanceMonitoringAdvice;
import com.nt.service.AirthmeticOperationsService;
import com.nt.service.IAirthmeticService;

public class ProgramaticSpringAOPTest {

	public static void main(String[] args) {
		AirthmeticOperationsService service=null;
		IAirthmeticService proxy=null;
		PerformanceMonitoringAdvice advice=null;
		ProxyFactory factory=null;
		
	   //create Target /service class obj
		service=new AirthmeticOperationsService();
		//create Advice class object
		advice=new PerformanceMonitoringAdvice();
		//create ProxyFactory
		factory=new ProxyFactory();
		factory.setTarget(service);
		factory.addAdvice(advice);
		factory.addInterface(IAirthmeticService.class);
		//get Proxy object
		proxy=(IAirthmeticService)factory.getProxy();
		//invoke the method
		System.out.println("Sum===>"+proxy.sum(10,20));
		System.out.println("...........................................");
		System.out.println("Sub===>"+proxy.sub(10,20));
		System.out.println("...........................................");
		System.out.println("Mul===>"+proxy.mul(10,20));
		System.out.println("...........................................");
		System.out.println("Div===>"+proxy.div(10,20));
		System.out.println("...........................................");
		
		System.out.println("Proxy obj class name::"+proxy.getClass());
		
	}//method
}//class
