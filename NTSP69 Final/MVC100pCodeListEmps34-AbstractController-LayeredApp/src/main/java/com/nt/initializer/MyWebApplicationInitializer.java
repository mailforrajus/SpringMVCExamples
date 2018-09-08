package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext childCtx=null,rootCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic registration=null;
		//create Two Containers
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMvcAppConfig.class);
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfig.class);
		//create and Register ContextLoaderListener
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		//create and register DispatcherServlet
		servlet=new DispatcherServlet(childCtx);
		registration=sc.addServlet("dispatcher",servlet);
		registration.addMapping("*.htm");
		registration.setLoadOnStartup(2);
	}//method
}//class
