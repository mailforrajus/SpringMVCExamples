package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAroundAdvice {
	
	public Object log(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		Object args[]=null;
		System.out.println("Entering into "+pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs()));
		//Modifying target method arg values..
		args=pjp.getArgs();
		if(((Float)args[0])<=10000 )
			args[1]=((Float)args[1])-0.5f;
		//controlling target method execution
		if(((Float)args[0])<=0 || ((Float)args[1]) <=0|| ((Float)args[2])<=0){
			throw new IllegalArgumentException("Invalid Inputs");
		}
		else{
		retVal=pjp.proceed(args);
		}
		System.out.println("Exiting from "+pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs()));
       //modifying target method return value..
		retVal=((Float)retVal)+ ((Float)retVal)*0.01f;		
		return retVal;
	}

}
