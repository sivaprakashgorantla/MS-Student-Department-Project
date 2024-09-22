package com.student.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.app.entity.Department;
import com.student.app.entity.Student;
import com.student.app.exception.StudentNotFoundException;
import com.student.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	//private String baseUrl = "http://localhost:8080/department/";
	private String baseUrl = "http://DEPARTMENTSERVICE:9092/department/";
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public String getStudentWithDepartment(Long id) {
		//Student student = studentRepository.findById(id).get();
		System.out.println("Student Service calss getStudentWithDepartment "+id);
		System.out.println("studentRepository.findById(id) :"+studentRepository.findById(id));
		Student student = studentRepository.findById(id) .orElseThrow(() -> new StudentNotFoundException(id));
		System.out.println("Retrive database from student details "+student);
		System.out.println("Base Url  "+baseUrl+""+student.getDepartmentId());
		Department department = restTemplate.getForObject(baseUrl+student.getDepartmentId(), Department.class);
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n");
		buffer.append(student.getStudentId()+"  "+student.getFirstName()+ "  "+student.getLastName()+"  "+student.getEmail()+"  "+student.getDepartmentId());
		buffer.append("\n");
		buffer.append(department.getDepartmentName()+"  "+department.getDepartmentCode()+"  "+department.getDepartmentAddress());
		logger.info("Student with department details :"+buffer.toString());
		return buffer.toString();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		System.out.println("StudentSErvice getAllStudents");
		return studentRepository.findAllByOrderByStudentIdAsc();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		
		Student oldStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
		if(student !=null ) {
			oldStudent.setFirstName(student.getFirstName());
			oldStudent.setLastName(student.getLastName());
			oldStudent.setEmail(student.getEmail());
		}
		
		return studentRepository.save(oldStudent);
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		 if (!studentRepository.existsById(id)) {
	            throw new StudentNotFoundException(id);
	        }
	        studentRepository.deleteById(id);
	}
}
