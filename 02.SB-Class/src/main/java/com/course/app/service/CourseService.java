package com.course.app.service;

import java.util.List;

import com.course.app.entity.Course;

public interface CourseService {

	public Course saveCourse(Course course) ;
	
	public Course getCourseById(Long id);

	public List<Course> getAllCourse();

	public void deleteCourseById(Long id);

	public Course updateCourse(Long id, Course course );
	
}
