package com.student.app.service;

import java.util.List;

import com.student.app.entity.Student;
import com.student.app.response.StudentResponse;

public interface StudentService {

	public Student saveStudent(Student student) ;
	
	public Student getStudentById(Long id);
	
	String getStudentWithDepartment(Long id) ;

	public List<Student> getAllStudents();
	
	Student updateStudent(Long id, Student student);
	
	void deleteStudentById(Long id);

	public StudentResponse getStudentDetailsById(Long id);
	
}
