package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAdvice {
	
	public  Object monitor(ProceedingJoinPoint pjp)throws Throwable{
		long start=0,end=0;
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=pjp.proceed();
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms  to finish the execution");
		return retVal;
	}

}
