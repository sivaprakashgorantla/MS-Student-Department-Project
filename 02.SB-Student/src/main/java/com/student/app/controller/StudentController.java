package com.student.app.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.student.app.entity.Student;
import com.student.app.exception.StudentNotFoundException;
import com.student.app.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api/student")
@RefreshScope

public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@Value("${app.title}")
	private String title;
	
	@PostMapping("")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	
	// This method will be triggered for a GET request to "/api/students"
    @GetMapping("")
    public List<Student> getAllStudents() {
    	System.out.println("StudentController getAllStudents ");
		System.out.println("StudentController Students Data  "+studentService.getAllStudents());
    	return studentService.getAllStudents();
    }
    

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	
	
    @GetMapping("/config")
    public ResponseEntity<String> showProductMsg() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

	
	@GetMapping("/{id}/withDept")
	 @CircuitBreaker(name="studentservice", fallbackMethod="fallbackMethod")
	 @Retry(name="studentservice")
	 @TimeLimiter(name="studentservice")
	 @ResponseStatus(HttpStatus.ACCEPTED)
	
	public CompletableFuture<String> getStudentWithDepartment(@PathVariable Long id) {
		return CompletableFuture.supplyAsync(()->studentService.getStudentWithDepartment(id));
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CompletableFuture<String> fallbackMethod(@PathVariable Long id, RuntimeException ex) {
		return CompletableFuture.supplyAsync(()->"Fallback method '@CircuitBreaker ' Service is down. Please try after some time.");
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id , @RequestBody Student student){
				return studentService.updateStudent(id , student);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> updateStudent(@PathVariable Long id ){
		studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
	}
	
	// Exception Handler for StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}