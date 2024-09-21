package com.department.app.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private	final Long deptId;

	public 	DepartmentNotFoundException(Long deptId) {
		super("Department with ID " + deptId + " not found");
		this.deptId = deptId;
	}

	public Long getDeptId() {
		return deptId;
	}

}