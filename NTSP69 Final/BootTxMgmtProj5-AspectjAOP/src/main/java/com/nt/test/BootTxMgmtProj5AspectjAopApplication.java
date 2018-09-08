package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class BootTxMgmtProj5AspectjAopApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		ctx=SpringApplication.run(BootTxMgmtProj5AspectjAopApplication.class, args);
		//get Proxy object
				proxy=ctx.getBean("bankService",BankService.class);
				//invoke b.methiod
				try{
					System.out.println("result--->"+proxy.transferMoney(1006,1002, 2000));
				}
				catch(Exception re){
					System.out.println(re.getMessage());
				}
				
				//close container
				((AbstractApplicationContext) ctx).close();
	}//main
}//class
