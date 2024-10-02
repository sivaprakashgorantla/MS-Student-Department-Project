package com.department.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.app.entity.Department;
import com.department.app.exception.DepartmentNotFoundException;
import com.department.app.loader.DataLoader;
import com.department.app.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		LOGGER.info("DepartmentServiceImpl  getDepartmentById : "+id);
		return departmentRepository.findById(id).get();
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		LOGGER.info("DepartmentServiceImpl  getAllCourses : "+departmentRepository.findAll());
		return  departmentRepository.findAll();
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		LOGGER.info("DepartmentServiceImpl  deleteStudentById : "+id);
		if (!departmentRepository.existsById(id)) {
            throw new DepartmentNotFoundException(id);
        }
		departmentRepository.deleteById(id);
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		// TODO Auto-generated method stub
		LOGGER.info("DepartmentServiceImpl  updateDepartment : "+id);
		Department oldDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
		if(department !=null ) {
			oldDepartment.setDepartmentName(department.getDepartmentName());
			oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
			oldDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		departmentRepository.save(oldDepartment);
		
		return null;
	}
}
