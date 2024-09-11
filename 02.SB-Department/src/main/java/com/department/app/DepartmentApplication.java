package com.department.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentApplication {

	private static final Logger LOGGER = LogManager.getLogger(DepartmentApplication.class);

	
	public static void main(String[] args) {
		LOGGER.info("DepartmentApplication.............");
        
		SpringApplication.run(DepartmentApplication.class, args);
	}

}
