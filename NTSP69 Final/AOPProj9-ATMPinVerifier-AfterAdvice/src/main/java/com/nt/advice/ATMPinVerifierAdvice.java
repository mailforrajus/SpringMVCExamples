package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ATMPinVerifierAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
		int pin[]=(int[])retVal;
		
		pin[0]=pin[0]+1;
		
		if(((Integer)pin[0])<1000 || ((Integer)pin[0])>9999){
			throw new IllegalArgumentException("Invalid Pin number");
		}
		

	}

}
