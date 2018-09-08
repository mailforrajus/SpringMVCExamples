package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

@SpringBootApplication
@Import({RootAppConfig.class,WebMvcAppConfig.class})
public class MvcBoot39AbstractControllerLayeredAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBoot39AbstractControllerLayeredAppApplication.class, args);
	}
}
