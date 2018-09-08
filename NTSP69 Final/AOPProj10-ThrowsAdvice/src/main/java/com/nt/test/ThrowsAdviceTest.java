package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.errors.InternalProblemException;
import com.nt.service.BillAmountCalculator;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
     ApplicationContext ctx=null;
     BillAmountCalculator proxy=null;
		//create IOC Container
     ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      //getBean
     proxy=ctx.getBean("pfb",BillAmountCalculator.class);
     
     //invoke method
     try{
    	 System.out.println("Bill Amount::"+proxy.calcPrice(1000,200));
     }
     catch(InternalProblemException e){
    	 e.printStackTrace();
     }
     catch(Exception e){
    	 e.printStackTrace();
     }
		System.out.println("......................................");
		  try{
		    	 System.out.println("Bill Amount::"+proxy.calcPrice(0,0));
		     }
		  catch(InternalProblemException e){
		    	 e.printStackTrace();
		     }
		     catch(Exception e){
		    	 e.printStackTrace();
		     }
     //close container
		  ((AbstractApplicationContext) ctx).close();
	}

}
