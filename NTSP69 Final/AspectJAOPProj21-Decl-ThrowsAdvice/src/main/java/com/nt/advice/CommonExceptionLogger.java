package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger  {
	
	public void exceptionLogger(JoinPoint jp,IllegalArgumentException iae){
		System.out.println(iae.toString()+" Exception is raised in"+jp.getSignature()+" method with args  "+Arrays.toString(jp.getArgs())+" in target class "+jp.getTarget().getClass());
	}
}
