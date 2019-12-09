package com.tkksys.backendninja.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tkksys.backendninja.entity.Course;
@Service
public interface CourseService {

	public abstract List<Course> listAllCourses();
	public abstract Course addCouse(Course course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);
	
}
