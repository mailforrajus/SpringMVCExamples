package com.nt.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nt.config.WebMVCConfig;
import com.nt.test.MvcBoot41LoginAppSfcLayeredAppApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MvcBoot41LoginAppSfcLayeredAppApplication.class,WebMVCConfig.class);
	}

}
