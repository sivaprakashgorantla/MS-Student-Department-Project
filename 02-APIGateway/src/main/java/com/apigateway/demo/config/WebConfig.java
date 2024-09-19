package com.apigateway.demo.config;


import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig{/* extends org.springframework.web.cors.CorsConfiguration{

    @Bean
    public CorsWebFilter corsWebFilter() {
        final CorsConfiguration corsConfig = new CorsConfiguration();
        
        corsConfig.setMaxAge(Long.parseLong("3600"));
        corsConfig.setAllowedMethods(Arrays.asList("*"));
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowedOriginPatterns(Collections.singletonList("https://localhost:4200"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
*/}