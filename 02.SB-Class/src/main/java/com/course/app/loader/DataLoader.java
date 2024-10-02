package com.course.app.loader;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.course.app.controller.CourseController;
import com.course.app.entity.Course;
import com.course.app.repository.CourseRepository;

@Component
public class DataLoader implements CommandLineRunner {


	private static final Logger LOGGER = LogManager.getLogger(DataLoader.class);


	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 List<Course> courses = List.of(
				 new Course(3001L,"C","SSC",65),
				 new Course(3002L,"C++","PUC",70),
				 new Course(3003L,"JAVA","GRADUATION",120),
				 new Course(3004L,"GOOGLE CLOUD PLATFORM","gcp",40),
				 new Course(3005L,"DEVops","DEVops",50));
		 
		 //courseRepository.saveAll(courses);
				 
		 LOGGER.info("courses =DataLoader");
		
	}

}
