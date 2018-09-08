package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.AuthenticationManager;
import com.nt.service.BankService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class BootAopProj7SpringAopDeclSecurityCheckApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankService proxy=null;
		//create IOC container
		ctx=SpringApplication.run(BootAopProj7SpringAopDeclSecurityCheckApplication.class, args);
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
