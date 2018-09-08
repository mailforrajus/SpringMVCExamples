package com.nt.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.advice.SecurityCheckAdvice;
import com.nt.service.BankService;

@Configuration
@ComponentScan(basePackages="com.nt.advice")
public class AOPConfig {
	@Autowired
   private BankService service;
	@Autowired
	private SecurityCheckAdvice advice;
	
	@Bean(name="pfb")
	public  ProxyFactoryBean createProxyFactoryBean()throws Exception{
		ProxyFactoryBean pfb=new ProxyFactoryBean();
		pfb.setTarget(service);
		pfb.setInterceptorNames("securityAdvice");
		pfb.setProxyInterfaces(new Class[]{BankService.class});
		return pfb;
	}
	
	@Bean(name="proxyPfb")
	public  BankService  createProxy()throws Exception{
		return   (BankService) createProxyFactoryBean().getObject();
	}
	
}
