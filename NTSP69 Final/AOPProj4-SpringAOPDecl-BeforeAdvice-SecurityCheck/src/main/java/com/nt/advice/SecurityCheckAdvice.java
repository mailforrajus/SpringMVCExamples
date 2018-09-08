package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.service.AuthenticationManager;

public class SecurityCheckAdvice implements MethodBeforeAdvice {

	private AuthenticationManager manager;

	public SecurityCheckAdvice(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
           if(!manager.isAuthenticated()){
        	   throw new IllegalAccessException(" invalid Credentials");
           }
	}

}
