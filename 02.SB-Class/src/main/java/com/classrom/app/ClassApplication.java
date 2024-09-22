package com.classrom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
public class ClassApplication {

	private static final Logger LOGGER = LogManager.getLogger(ClassApplication.class);

	
	public static void main(String[] args) {
		LOGGER.info("ClassApplication.............");
        
		SpringApplication.run(ClassApplication.class, args);
	}

}
