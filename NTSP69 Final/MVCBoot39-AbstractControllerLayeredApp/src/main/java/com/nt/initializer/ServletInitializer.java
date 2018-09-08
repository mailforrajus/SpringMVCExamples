package com.nt.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nt.config.WebMvcAppConfig;
import com.nt.test.MvcBoot39AbstractControllerLayeredAppApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MvcBoot39AbstractControllerLayeredAppApplication.class,WebMvcAppConfig.class);
	}

}
