package com.nt.intializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	public MyWebApplicationInitializer() {
		System.out.println("MyWebApplicationInitializer:0-param constructor");
	}
	
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("MyWebApplicationInitializer:onStartup(-)");
		AnnotationConfigWebApplicationContext childCtx=null,rootCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic registration=null;
		//create two containers
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMVCAppConfig.class);
		
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfig.class);
		
		//create and register ContextLoaderListener
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		
		//create and register DispatherServlet
		servlet=new DispatcherServlet(childCtx);
		registration=sc.addServlet("dispatcher",servlet);
		registration.addMapping("*.htm");
		registration.setLoadOnStartup(2);
	}

}
