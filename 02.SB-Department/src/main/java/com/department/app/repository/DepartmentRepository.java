package com.department.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.department.app.entity.Department;

@Component
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	List<Department> findAllByOrderByDepartmentIdAsc();
}