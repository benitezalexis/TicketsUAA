package com.tkksys.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tkksys.backendninja.entity.Course;
import com.tkksys.backendninja.repository.CourseJpaRepository;
import com.tkksys.backendninja.service.CourseService;

public class CourseServiceImpl implements CourseService{
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourses() {
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCouse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
