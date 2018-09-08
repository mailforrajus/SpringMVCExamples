package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

@SpringBootApplication
@Import({RootAppConfig.class,WebMVCConfig.class})
public class MvcBoot41LoginAppSfcLayeredAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBoot41LoginAppSfcLayeredAppApplication.class, args);
	}
}
