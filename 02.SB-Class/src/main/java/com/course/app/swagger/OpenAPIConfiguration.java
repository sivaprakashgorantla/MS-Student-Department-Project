package com.classrom.app.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       Server server = new Server();
       server.setUrl("http://localhost:9093");
       server.setDescription("Class");

       Contact myContact = new Contact();
       myContact.setName("Sivaprakash Gorantla");
       myContact.setEmail("sivaprakashgorantla@gmail.com");

       Info information = new Info()
               .title("Class Management System API")
               .version("1.0")
               .description("This API exposes endpoints to manage Class.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}