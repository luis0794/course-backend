package com.ltobar.course.repository;

import com.ltobar.course.model.Course;
import com.ltobar.course.repository.custom.CustomCourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>, CustomCourseRepository {
}
