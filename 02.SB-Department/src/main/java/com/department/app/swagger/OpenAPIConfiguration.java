package com.department.app.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.department.app.service.DepartmentServiceImpl;



@Configuration
public class OpenAPIConfiguration {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

   @Bean
   public OpenAPI defineOpenApi() {
	   LOGGER.info("Department OpenAPIConfiguration");
       Server server = new Server();
       server.setUrl("http://localhost:9093");
       server.setDescription("Development");

       Contact myContact = new Contact();
       myContact.setName("Sivaprakash Gorantla");
       myContact.setEmail("sivaprakashgorantla@gmail.com");

       Info information = new Info()
               .title("Department Management System API")
               .version("1.0")
               .description("This API exposes endpoints to manage employees.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}