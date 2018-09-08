package com.nt.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nt.config.WebMVCAppConfig;
import com.nt.test.MvcBoot37WishAppGradleApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MvcBoot37WishAppGradleApplication.class,WebMVCAppConfig.class);
	}

}
