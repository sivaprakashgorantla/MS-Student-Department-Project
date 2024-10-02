package com.course.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.course.app.entity.Course;


@Component
public interface CourseRepository extends JpaRepository<Course, Long>{

}