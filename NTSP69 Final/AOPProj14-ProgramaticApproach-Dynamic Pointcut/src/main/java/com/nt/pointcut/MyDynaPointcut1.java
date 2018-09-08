package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.AirthmeticOperationsService;

public class MyDynaPointcut1 extends DynamicMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(method.getName().equals("mul") && targetClass==AirthmeticOperationsService.class && ((Integer)args[0])>=1000 &&  ((Integer)args[1])>=1000)
		   return true;
		   else
			   return false;
	}
}
