package com.apigateway.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Apply CORS to all endpoints
						.allowedOrigins("http://localhost:4200") // Allowed origins
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
						.allowedHeaders("Authorization", "Content-Type") // Allowed headers
						.allowCredentials(true); // Allow credentials
			}
		};
	}
}