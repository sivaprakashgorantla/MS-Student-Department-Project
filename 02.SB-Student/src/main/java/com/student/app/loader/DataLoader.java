package com.student.app.loader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.student.app.entity.Student;
import com.student.app.repository.StudentRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		logger.info("Data loder run method ");
		 List<Student> departments = List.of(
				 new Student(2001L,"Sivaprakash","Gorantla","sivaprakashgorantla@gmail.com",10001L,30001L),
				 new Student(2002L,"Arunaprakash","Gorantla","sivaprakashgorantla@gmail.com",10005L,30002L),
				 new Student(2003L,"Saanvi","Gorantla","sivaprakashgorantla@gmail.com",10006L,30003L),
				 new Student(2004L,"Samanvitha","Gorantla","sivaprakashgorantla@gmail.com",10005L,30004L),
				 new Student(2005L,"Rahul","Garadimani","rahulgaradimani@gmail.com",10002L,30001L),
				 new Student(2006L,"Aravind","Garadimani","avarindgaradimani@gmail.com",10003L,30002L));
		 
				//studentRepository.saveAll(departments);
				 
		System.out.println("=======================================DataLoader");
		
	}

}
