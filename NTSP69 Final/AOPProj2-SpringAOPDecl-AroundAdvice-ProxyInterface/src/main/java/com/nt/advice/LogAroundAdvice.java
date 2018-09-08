package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogAroundAdvice implements MethodInterceptor {
	private static Logger logger=Logger.getLogger(LogAroundAdvice.class);
    static{
    	PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
    }
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object[] args=null;
		logger.debug("Entering into "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		//modifying arg values

		retVal=invocation.proceed();
		logger.debug("Exiting from "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		//modifying return values
		retVal=((Float)retVal)+((Float)retVal)*0.01f;
		return retVal;
	}

}
