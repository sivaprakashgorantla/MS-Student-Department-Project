package com.department.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.app.DepartmentApplication;
import com.department.app.entity.Department;
import com.department.app.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger LOGGER = LogManager.getLogger(DepartmentController.class);

	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		LOGGER.info( "Save Department "+department);
		return departmentService.saveDepartment(department);
	}


	@GetMapping("/")
	public String hello() {
		LOGGER.info( "hello ");
		return "Department Controller Hello!! Sivaprakash Gorantla";
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		System.out.println("Department Controller getDepartmentById : "+id);
		return departmentService.getDepartmentById(id);
	}
}