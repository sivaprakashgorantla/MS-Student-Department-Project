package com.student.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.app.StudentApplication;
import com.student.app.entity.Department;
import com.student.app.entity.Student;
import com.student.app.exception.StudentNotFoundException;
import com.student.app.openfeignclient.CourseClient;
import com.student.app.repository.StudentRepository;
import com.student.app.response.CourseResponse;
import com.student.app.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentApplication.class);

	//private String baseUrl = "http://localhost:8080/department/";
	private String baseUrl = "http://DEPARTMENTSERVICE:9092/department/";
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CourseClient courseClient ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Student saveStudent(Student student) {
		logger.info("StudentServiceImpl saveStudent ");
		return studentRepository.save(student);
	}
	
	public String getStudentWithDepartment(Long id) {
		//Student student = studentRepository.findById(id).get();
		logger.info("StudentServiceImpl getStudentWithDepartment  "+id);
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
		// TODO Auto-generated method stub4
		logger.info("StudentServiceImpl getStudentById  "+id);
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		logger.info("StudentServiceImpl getAllStudents  ");
		return studentRepository.findAllByOrderByStudentIdAsc();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		logger.info("StudentServiceImpl updateStudent  "+id +" : "+student);
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
		logger.info("StudentController deleteStudentById "+id);
		// TODO Auto-generated method stub
		 if (!studentRepository.existsById(id)) {
	            throw new StudentNotFoundException(id);
	        }
	        studentRepository.deleteById(id);
	}

	@Override
	public StudentResponse getStudentDetailsById(Long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).get();
		
		StudentResponse studentRespose = modelMapper.map(student,StudentResponse.class);
		
		CourseResponse courseResponse = courseClient.getCourseByStudentId(student.getCourseId()).getBody();
		
		studentRespose.setCourseResponse(courseResponse);
		return studentRespose;
	}
}
