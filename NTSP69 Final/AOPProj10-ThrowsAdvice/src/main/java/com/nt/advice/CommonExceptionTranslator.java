package com.nt.advice;

import org.springframework.aop.ThrowsAdvice;

import com.nt.errors.InternalProblemException;

public class CommonExceptionTranslator implements ThrowsAdvice {
	
	public void afterThrowing(IllegalArgumentException iae)throws InternalProblemException{
		throw new InternalProblemException(iae.getMessage()); //exception graphing/translation
	}
	

}
