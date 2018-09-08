package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.AuthenticationManager;
import com.nt.service.BankService;

public class BeforeAdviceSecurityCheckTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//signIn to account
		manager.signIn("raja", "rani1");
		//get Proxy object
		proxy=ctx.getBean("pfb",BankService.class);
		try{
		System.out.println("Withdrawn?::"+proxy.withdraw(1001,2000));
		System.out.println("Deposited?::"+proxy.deposite(1001,5000));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//signout
	   manager.signOut();
		//close container
	   ((AbstractApplicationContext) ctx).close();

	}

}
