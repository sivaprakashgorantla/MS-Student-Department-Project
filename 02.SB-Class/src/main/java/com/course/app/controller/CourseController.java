package com.course.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.course.app.entity.Course;
import com.course.app.exception.CourseNotFoundException;
import com.course.app.service.CourseService;

@RestController
@RequestMapping("/api/course")
@RefreshScope
public class CourseController {

	private static final Logger LOGGER = LogManager.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@Value("${app.title}")
	private String title;
	
    @GetMapping("/config")
    public ResponseEntity<String> showProductMsg() {
    	LOGGER.info("CourseController  showProductMsg");
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

	// This method will be triggered for a GET request to
	@GetMapping("")
	public List<Course> getAllCourses() {
		LOGGER.info("CourseController  getAllCourses : "+courseService.getAllCourse());
		return courseService.getAllCourse();
	}

	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id){
		LOGGER.info("CourseController  getCourseById :"+id);
		return courseService.getCourseById(id);
	}
	
	@PostMapping("")
	public Course saveCourse(@RequestBody Course course) {
		LOGGER.info("CourseController  saveCourse :"+course);
		return courseService.saveCourse(course);
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		LOGGER.info("CourseController  updateCourse :"+ id +" : "+course);
		return courseService.updateCourse(id, course);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
		LOGGER.info("CourseController  deleteCourseById :"+ id);
		courseService.deleteCourseById(id);
		return ResponseEntity.noContent().build();
	}

	// Exception Handler for ClassRoomNotFoundException
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(CourseNotFoundException ex) {
		LOGGER.info("CourseController  handleStudentNotFoundException :"+ ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}