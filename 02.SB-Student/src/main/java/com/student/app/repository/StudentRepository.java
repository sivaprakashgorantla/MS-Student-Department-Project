package com.student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.student.app.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}