package com.classrom.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "MS_CLASSES")
public class ClassRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long classId;
	private String className;
	private String classCode;

	public ClassRoom() {
		super();
	}

	public ClassRoom(Long classId, String className, String classCode) {
		super();
		this.classId = classId;
		this.className = className;
		this.classCode = classCode;
	}

	/**
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the classCode
	 */
	public String getClassCode() {
		return classCode;
	}

	/**
	 * @param classCode the classCode to set
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	@Override
	public String toString() {
		return "ClassRoom [classId=" + classId + ", className=" + className + ", classCode=" + classCode + "]";
	}


}