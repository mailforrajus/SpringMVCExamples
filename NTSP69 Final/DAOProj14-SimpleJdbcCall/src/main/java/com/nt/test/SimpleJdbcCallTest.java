package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;


import com.nt.service.AuthenticateService;

public class SimpleJdbcCallTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticateService  service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("authService",AuthenticateService.class);
		//prepare DTO class obj
		try{
			System.out.println(service.login("raja","rani"));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
	

}
