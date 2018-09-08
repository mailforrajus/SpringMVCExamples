package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.AirthmeticOperationsService;

public class MyStaticPoincut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(method.getName().equals("sum") && targetClass==AirthmeticOperationsService.class)
     		return true;
		else
			return false;
	}

}
