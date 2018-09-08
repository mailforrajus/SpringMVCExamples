package com.nt.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nt.config.WebMVCAppConfig;
import com.nt.test.BootSpringSecurityBankApp5Application;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootSpringSecurityBankApp5Application.class,WebMVCAppConfig.class);
		//return application.parent(BootSpringSecurityBankApp5Application.class).child(WebMVCAppConfig.class);
		
	}

}
