package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponGenerationAdvice  {


	/*public void generateCupon(JoinPoint jp,int billAmt) throws Throwable {
		String discountCuponMsg=null;
		Writer writer=null;
		System.out.println("target method return Val::"+billAmt);
		System.out.println("Target method name::"+jp.getSignature());
		System.out.println("Target method args::"+Arrays.deepToString(jp.getArgs()));
		System.out.println("Target   class name::"+jp.getTarget().getClass());
		
		if(billAmt>=50000)
			discountCuponMsg="Avail 40% discount on next Bill Amount";
		else if(billAmt>=40000)
			discountCuponMsg="Avail 30% discount  on next Bill Amount";
		else if(billAmt>=30000)
			discountCuponMsg="Avail 20% discount  on next Bill Amount";
		else if(billAmt>=10000)
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
*/
	public void generateCupon(int billAmt) throws Throwable {
		String discountCuponMsg=null;
		Writer writer=null;
		if(billAmt>=50000)
			discountCuponMsg="Avail 40% discount on next Bill Amount";
		else if(billAmt>=40000)
			discountCuponMsg="Avail 30% discount  on next Bill Amount";
		else if(billAmt>=30000)
			discountCuponMsg="Avail 20% discount  on next Bill Amount";
		else if(billAmt>=10000)
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
