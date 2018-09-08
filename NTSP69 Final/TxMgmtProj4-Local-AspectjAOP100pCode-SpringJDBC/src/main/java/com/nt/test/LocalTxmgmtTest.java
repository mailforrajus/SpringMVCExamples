package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class LocalTxmgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke b.methiod
		try{
			System.out.println("result--->"+proxy.transferMoney(1001,1008, 2000));
		}
		catch(Exception re){
			System.out.println(re.getMessage());
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
