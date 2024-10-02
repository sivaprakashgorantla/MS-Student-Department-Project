package com.student.app.response;

public class StudentResponse {
	private Long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private CourseResponse courseResponse;
	public StudentResponse() {}
	public StudentResponse(Long studentId, String firstName, String lastName, String email, CourseResponse courseResponse) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseResponse = courseResponse;
	}
	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the courseResponse
	 */
	public CourseResponse getCourseResponse() {
		return courseResponse;
	}
	/**
	 * @param courseResponse the courseResponse to set
	 */
	public void setCourseResponse(CourseResponse courseResponse) {
		this.courseResponse = courseResponse;
	}
	@Override
	public String toString() {
		return "StudentResponse [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", courseResponse=" + courseResponse + "]";
	}
	
	
}
