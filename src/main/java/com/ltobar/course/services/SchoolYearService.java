package com.ltobar.course.services;

import com.ltobar.course.common.vo.request.RegisterSchoolYearReqVO;
import com.ltobar.course.common.vo.request.UpdateSchoolYearReqVO;
import com.ltobar.course.common.vo.response.SchoolYearVO;
import com.ltobar.course.model.SchoolYear;

import javax.validation.Valid;
import java.util.List;

public interface SchoolYearService {

    List<SchoolYearVO> findAll();

    SchoolYearVO findById(Integer id);

    SchoolYear createSchoolYear(@Valid RegisterSchoolYearReqVO request);

    void updateSchoolYear(@Valid UpdateSchoolYearReqVO request);

    void deleteSchoolYear(Integer id);

}
