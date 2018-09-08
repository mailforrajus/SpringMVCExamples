package com.nt.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@SpringBootApplication
@Import(value={ServiceConfig.class,PersistenceConfig.class,AOPConfig.class})
public class RootAppConfig {

}
