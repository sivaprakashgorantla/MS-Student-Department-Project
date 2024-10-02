package com.classrom.app.exception;

public class ClassRoomNotFoundException extends RuntimeException {

	private	final Long classId;

	public 	ClassRoomNotFoundException(Long classId) {
		super("Class with ID " + classId + " not found");
		this.classId = classId;
	}

	/**
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

}