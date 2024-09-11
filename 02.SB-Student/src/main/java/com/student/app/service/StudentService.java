package com.student.app.service;

import java.util.List;

import com.student.app.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student) ;
	
	public Student getStudentById(Long id);
	
	String getStudentWithDepartment(Long id) ;

	public List<Student> getAllStudents();
	
}
