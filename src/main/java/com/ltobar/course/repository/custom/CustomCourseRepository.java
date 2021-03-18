package com.ltobar.course.repository.custom;

import com.ltobar.course.common.vo.request.UpdateCourseReqVO;

public interface CustomCourseRepository {

    void updateCourse(UpdateCourseReqVO request);
}
