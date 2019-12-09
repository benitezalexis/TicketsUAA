package com.tkksys.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkksys.backendninja.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

	

}
