package com.department.app.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.department.app.entity.Department;
import com.department.app.exception.DepartmentNotFoundException;
import com.department.app.service.DepartmentService;


@RestController
@RequestMapping("/api/department/")
@RefreshScope
public class DepartmentController {

	private static final Logger LOGGER = LogManager.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@Value("${app.title}")
	private String title;
	
    @GetMapping("/config")
    public ResponseEntity<String> showProductMsg() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

	// This method will be triggered for a GET request to
	@GetMapping("")
	public List<Department> getAllDepartments() {
		System.out.println("DepartmentController getAllDepartments ");
		System.out.println("DepartmentController Students Data  " + departmentService.getAllDepartments());
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id){
		return departmentService.getDepartmentById(id);
	}
	
	
	@PostMapping("")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}


	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteDepartment(@PathVariable Long id) {
		departmentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}

	// Exception Handler for DepartmentNotFoundException
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(DepartmentNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}