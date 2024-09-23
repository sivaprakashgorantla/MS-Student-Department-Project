package com.classrom.app.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.classrom.app.entity.ClassRoom;
import com.classrom.app.exception.ClassRoomNotFoundException;
import com.classrom.app.service.ClassService;

@RestController
@RequestMapping("/api/class/")
public class ClassController {

	private static final Logger LOGGER = LogManager.getLogger(ClassController.class);

	@Autowired
	private ClassService classRepository;

	@Value("${app.title}")
	private String title;
	
    @GetMapping("/config")
    public ResponseEntity<String> showProductMsg() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

	// This method will be triggered for a GET request to
	@GetMapping("")
	public List<ClassRoom> getAllClasses() {
		System.out.println("ClassController getAllClasses ");
		System.out.println("ClassController getAllClasses Data  " + classRepository.getAllClasses());
		return classRepository.getAllClasses();
	}

	@GetMapping("/{id}")
	public ClassRoom getClassById(@PathVariable Long id){
		return classRepository.getClassById(id);
	}
	
	@PostMapping("")
	public ClassRoom saveDepartment(@RequestBody ClassRoom classRoom) {
		return classRepository.saveClass(classRoom);
	}

	@PutMapping("/{id}")
	public ClassRoom updateDepartment(@PathVariable Long id, @RequestBody ClassRoom classRoom) {
		return classRepository.updateClasses(id, classRoom);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClassById(@PathVariable Long id) {
		classRepository.deleteClassById(id);
		return ResponseEntity.noContent().build();
	}

	// Exception Handler for ClassRoomNotFoundException
	@ExceptionHandler(ClassRoomNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(ClassRoomNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}