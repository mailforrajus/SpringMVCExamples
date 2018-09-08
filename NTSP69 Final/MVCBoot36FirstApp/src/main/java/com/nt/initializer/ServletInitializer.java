package com.nt.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nt.config.MVCWebAppConfig;
import com.nt.config.RootAppConfig;
import com.nt.test.MvcBoot36FirstAppApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return  builder.sources(MVCWebAppConfig.class,MvcBoot36FirstAppApplication.class);
	}
	
}
