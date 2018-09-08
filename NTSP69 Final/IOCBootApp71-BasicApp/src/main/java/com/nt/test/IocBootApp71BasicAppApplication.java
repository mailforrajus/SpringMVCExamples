package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(value=AppConfig.class)
public class IocBootApp71BasicAppApplication {
	static{
		System.out.println(" IocBootApp71BasicAppApplication:static block");
	}
	
	public static void main(String[] args) {
		System.out.println("main(-)");
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get IOC Container
		ctx=SpringApplication.run(IocBootApp71BasicAppApplication.class, args);
		System.out.println("after Gettig container");
		System.out.println(ctx.getClass());
		//get Bean
		generator=ctx.getBean("wish",WishMessageGenerator.class);
		//invoke method
		System.out.println("Result is::"+generator.generateWishMessage("raja"));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}
}
