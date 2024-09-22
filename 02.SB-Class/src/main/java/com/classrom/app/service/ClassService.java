package com.classrom.app.service;

import java.util.List;

import com.classrom.app.entity.ClassRoom;

public interface ClassService {

	public ClassRoom saveClass(ClassRoom classRoom) ;
	
	public ClassRoom getClassById(Long id);

	public List<ClassRoom> getAllClasses();

	public void deleteClassById(Long id);

	public ClassRoom updateClasses(Long id, ClassRoom classRoom);
	
}
