package com.classrom.app.service;

import java.util.List;


import com.classrom.app.entity.ClassRoom;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.classrom.app.repository.ClassRepository;
import com.classrom.app.exception.ClassRoomNotFoundException;


@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassRepository  classRepository;
	
	

	@Override
	public ClassRoom saveClass(ClassRoom department) {
		return classRepository.save(department);
	}

	@Override
	public ClassRoom getClassById(Long id) {
		return classRepository.findById(id).get();
	}

	@Override
	public List<ClassRoom> getAllClasses() {
		// TODO Auto-generated method stub
		return  classRepository.findAll();
	}

	@Override
	public void deleteClassById(Long id) {
		// TODO Auto-generated method stub
		if (!classRepository.existsById(id)) {
            throw new ClassRoomNotFoundException(id);
        }
		classRepository.deleteById(id);
	}

	@Override
	public ClassRoom updateClasses(Long id, ClassRoom classRoom) {
		// TODO Auto-generated method stub
		ClassRoom oldClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassRoomNotFoundException(id));
		if(classRoom !=null ) {
			oldClass.setClassName(classRoom.getClassName());
			oldClass.setClassCode(classRoom.getClassCode());
		}
		classRepository.save(oldClass);
		
		return null;
	}
}
