package com.department.app.loader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.department.app.entity.Department;
import com.department.app.repository.DepartmentRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		 List<Department> departments = List.of(
				 new Department(1001L,"DEV","IT","DEVIT"),
				 new Department(1002L,"SALES","MARKETING","BUSINESS"),
				 new Department(1003L,"PROD","IT","PRODIT"),
				 new Department(1004L,"ELECTICAL","MARKETING","BUSINESS"),
				 new Department(1005L,"POLITICS","POLITICS","POLITICS"),
				 new Department(1006L,"RAIWAY","RAIWAY","IRCTC"));
		 
		 //departmentRepository.saveAll(departments);
				 
		System.out.println("==========================================DataLoader");
		
	}

}
