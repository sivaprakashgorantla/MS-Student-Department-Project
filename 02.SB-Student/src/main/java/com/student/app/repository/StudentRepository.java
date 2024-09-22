package com.student.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.app.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findAllByOrderByStudentIdAsc();
}