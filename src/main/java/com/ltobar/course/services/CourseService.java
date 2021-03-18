package com.ltobar.course.services;

import com.ltobar.course.common.vo.request.RegisterCourseReqVO;
import com.ltobar.course.common.vo.request.UpdateCourseReqVO;
import com.ltobar.course.model.Course;

import javax.validation.Valid;
import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(Integer id);

    Course createCourse(@Valid RegisterCourseReqVO request);

    void updateCourse(@Valid UpdateCourseReqVO request);

    void deleteCourse(Integer id);

}
