package com.course.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.app.entity.Course;
import com.course.app.exception.CourseNotFoundException;
import com.course.app.repository.CourseRepository;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Logger LOGGER = LogManager.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	Tracer tracer;

	@Override
	public Course getCourseById(Long id) {
		LOGGER.info("CourseServiceImpl getCourseById : " + id);
		LOGGER.info("CourseServiceImpl deleteCourseById : " + id);

		LOGGER.info("logs before custom span");
		Span newSpan = this.tracer.nextSpan().name("custom-log");
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
			// ...
			// You can tag a span
			newSpan.tag("custom-tag", "##333##");
			// ...
			LOGGER.info("Logs in custom span");
		} finally {
			// Once done remember to end the span. This will allow collecting
			// the span to send it to a distributed tracing system e.g. Zipkin
			newSpan.end();
		}
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		LOGGER.info("CourseServiceImpl getAllCourse : " + courseRepository.findAll());
		return courseRepository.findAll();
	}

	@Override
	public void deleteCourseById(Long id) {
		// TODO Auto-generated method stub
		LOGGER.info("CourseServiceImpl deleteCourseById : " + id);

		LOGGER.info("logs before custom span");
		Span newSpan = this.tracer.nextSpan().name("custom-log");
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
			// ...
			// You can tag a span
			newSpan.tag("custom-tag", "##333##");
			// ...
			LOGGER.info("Logs in custom span");
		} finally {
			// Once done remember to end the span. This will allow collecting
			// the span to send it to a distributed tracing system e.g. Zipkin
			newSpan.end();
		}
		if (!courseRepository.existsById(id)) {
			throw new CourseNotFoundException(id);
		}
		courseRepository.deleteById(id);
	}

	@Override
	public Course updateCourse(Long id, Course course) {
		// TODOAuto-generated method stub
		LOGGER.info("CourseController  updateCourse :" + id + " : " + course);
		Course oldCourse = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
		if (course != null) {
			oldCourse.setCourseName(course.getCourseName());
			oldCourse.setCourseCode(course.getCourseCode());
			oldCourse.setDuration(course.getDuration());
		}
		courseRepository.save(oldCourse);

		return null;
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		LOGGER.info("CourseController  saveCourse :" + course);
		return courseRepository.save(course);
	}
}
