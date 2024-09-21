package com.department.app.service;

import java.util.List;

import com.department.app.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department) ;
	
	public Department getDepartmentById(Long id);

	public List<Department> getAllDepartments();

	public void deleteStudentById(Long id);

	public Department updateDepartment(Long id, Department department);
	
}
