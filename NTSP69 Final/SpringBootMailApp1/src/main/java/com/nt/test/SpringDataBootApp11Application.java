package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.MailSenderService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class SpringDataBootApp11Application {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx=null;
		MailSenderService sender=null;
		ctx=SpringApplication.run(SpringDataBootApp11Application.class, args);
		//get Service class obj
		sender=ctx.getBean("mailService",MailSenderService.class);
		//send email message
		sender.sendEmailMessage();
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
