package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.MVCWebAppConfig;
import com.nt.config.RootAppConfig;

@SpringBootApplication
@Import({RootAppConfig.class,MVCWebAppConfig.class})
public class MvcBoot36FirstAppApplication {

public static void main(String[] args) {
		SpringApplication.run(MvcBoot36FirstAppApplication.class, args);
	}
}
