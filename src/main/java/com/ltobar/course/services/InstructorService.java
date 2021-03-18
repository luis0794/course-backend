package com.ltobar.course.services;


import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.RegisterInstructorReqVO;
import com.ltobar.course.common.vo.request.UpdateInstructorReqVO;
import com.ltobar.course.model.Instructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface InstructorService {

    List<Instructor> findAll();

    Instructor findById(Integer id);

    Instructor createInstructor(@Valid RegisterInstructorReqVO request) throws AuthException;

    void updateInstructor(@Valid UpdateInstructorReqVO request);

    void deleteInstructor(Integer id);

}
