package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class DiscountCuponGenerationAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
		String discountCuponMsg=null;
		Writer writer=null;
		System.out.println("target method return Val::"+retVal);
		System.out.println("Target method name::"+method.getName());
		System.out.println("Target method args::"+Arrays.toString(args));
		System.out.println("Target   class name::"+target.getClass());
		
		if(((Integer) retVal)>=50000)
			discountCuponMsg="Avail 40% discount on next Bill Amount";
		else if((Integer)retVal>=40000)
			discountCuponMsg="Avail 30% discount  on next Bill Amount";
		else if((Integer)retVal>=30000)
			discountCuponMsg="Avail 20% discount  on next Bill Amount";
		else if((Integer)retVal>=10000)
			discountCuponMsg="Avail 10% discount  on next Bill Amount";
		else
			discountCuponMsg="Avail 5% discount  on next Bill Amount";
		
		try{
			writer=new FileWriter("E:/cupon.txt");
			writer.write(discountCuponMsg);
			writer.flush();
			writer.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}//method
}//class
