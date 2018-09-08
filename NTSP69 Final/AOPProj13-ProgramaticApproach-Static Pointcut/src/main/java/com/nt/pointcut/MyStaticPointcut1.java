package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.AirthmeticOperationsService;

public class MyStaticPointcut1 extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(method.getName().equals("mul") && targetClass.isAssignableFrom(AirthmeticOperationsService.class))
		     return true;
		else
			return false;
	}

}
