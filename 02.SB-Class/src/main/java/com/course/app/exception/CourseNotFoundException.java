package com.course.app.exception;

public class CourseNotFoundException extends RuntimeException {

	private	final Long courseId;

	public 	CourseNotFoundException(Long courseId) {
		super("Course with ID " + courseId + " not found");
		this.courseId = courseId;
	}

	/**
	 * @return the classId
	 */
	public Long getCourseId() {
		return courseId;
	}

}