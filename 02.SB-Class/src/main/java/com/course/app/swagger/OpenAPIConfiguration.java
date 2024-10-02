package com.course.app.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.course.app.service.CourseServiceImpl;



@Configuration
public class OpenAPIConfiguration {



	private static final Logger LOGGER = LogManager.getLogger(CourseServiceImpl.class);

	
   @Bean
   public OpenAPI defineOpenApi() {
	   LOGGER.info("Course Controller OpenAPIConfiguration");
       Server server = new Server();
       server.setUrl("http://localhost:9093");
       server.setDescription("Course");

       Contact myContact = new Contact();
       myContact.setName("Sivaprakash Gorantla");
       myContact.setEmail("sivaprakashgorantla@gmail.com");

       Info information = new Info()
               .title("Class Management System API")
               .version("1.0")
               .description("This API exposes endpoints to manage Course.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}