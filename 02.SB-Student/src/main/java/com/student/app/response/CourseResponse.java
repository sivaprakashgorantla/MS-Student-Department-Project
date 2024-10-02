package com.student.app.response;

public class CourseResponse {
	private Long courseId;
	private int duration;
	private String courseName;
	private String courseCode;
	
	public CourseResponse() {}
	public CourseResponse(Long courseId, int duration, String courseName, String courseCode) {
		super();
		this.courseId = courseId;
		this.duration = duration;
		this.courseName = courseName;
		this.courseCode = courseCode;
	}
	/**
	 * @return the courseId
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	@Override
	public String toString() {
		return "CourseResponse [courseId=" + courseId + ", duration=" + duration + ", courseName=" + courseName
				+ ", courseCode=" + courseCode + "]";
	}
	
	
}
