package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("allAspects")
@Aspect
public class AllAspects {
	
	@Pointcut("execution(* com.nt.service.ArithmeticService.*(..))")
	public void  myPtc(){
		
	}
	
	@Around(value="myPtc()")
	public  Object  logAround(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		System.out.println("entering into "+pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs()));
		retVal=pjp.proceed();
		System.out.println("exiting into "+pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs()));
		return retVal;
		
	}
	@Before(value="myPtc()")
	public  void  beforeLog(JoinPoint jp)throws Throwable{
		System.out.println("Before entering into "+jp.getSignature()+"with args"+Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(value="myPtc()",returning="result")
	public  void  afterLog(JoinPoint jp,Object result)throws Throwable{
		System.out.println("After exiting from "+jp.getSignature()+"with args"+Arrays.toString(jp.getArgs())+" with return value::"+result);
	}
	
	@AfterThrowing(value="myPtc()",throwing="iae")
	public  void  excpetionLog(JoinPoint jp,IllegalArgumentException iae)throws Throwable{
		System.out.println("After exiting from "+jp.getSignature()+"with args"+Arrays.toString(jp.getArgs())+" with exception ::"+iae);
	}
	
	
	

}
