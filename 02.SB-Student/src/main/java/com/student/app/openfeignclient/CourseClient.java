package com.student.app.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.app.response.CourseResponse;

@FeignClient(name="course-service",path = "/api/course")

public interface CourseClient { //proxy

	@RequestMapping("/{id}")
	public ResponseEntity<CourseResponse> getCourseByStudentId(@PathVariable Long id);
}
