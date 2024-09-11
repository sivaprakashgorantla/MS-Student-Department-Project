package com.department.app.service;

import com.department.app.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department) ;
	
	public Department getDepartmentById(Long id);
	
}
