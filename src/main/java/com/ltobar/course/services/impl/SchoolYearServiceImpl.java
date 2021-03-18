package com.ltobar.course.services.impl;

import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.RegisterSchoolYearReqVO;
import com.ltobar.course.common.vo.request.UpdateSchoolYearReqVO;
import com.ltobar.course.common.vo.response.SchoolYearVO;
import com.ltobar.course.model.SchoolYear;
import com.ltobar.course.repository.SchoolYearRepository;
import com.ltobar.course.services.SchoolYearService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class SchoolYearServiceImpl implements SchoolYearService {

    @Autowired
    private SchoolYearRepository repository;


    @Override
    public List<SchoolYearVO> findAll() {
        try {
            List<SchoolYear> repositoryResponse = this.repository.findAll();
            List<SchoolYearVO> response = new ArrayList<>();

            repositoryResponse.forEach(r ->
                    response.add(SchoolYearVO
                            .builder()
                            .id(r.getId())
                            .courseId(r.getCourseId())
                            .courseName(r.getCourse().getName())
                            .instructorId(r.getInstructorId())
                            .instructorName(r.getInstructor().getName())
                            .year(r.getYear())
                            .build()));

            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar a los periodos curso/instructor.");
        }
    }

    @Override
    public SchoolYearVO findById(Integer id) {
        try {
            SchoolYear repositoryResponse = this.repository.findById(id)
                    .orElseThrow(() -> new AuthException("Periodo curso/instructor no encontrado."));

            return SchoolYearVO
                    .builder()
                    .id(repositoryResponse.getId())
                    .courseId(repositoryResponse.getCourseId())
                    .courseName(repositoryResponse.getCourse().getName())
                    .instructorId(repositoryResponse.getInstructorId())
                    .instructorName(repositoryResponse.getInstructor().getName())
                    .year(repositoryResponse.getYear())
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar el periodo curso/instructor.");
        }
    }

    @Override
    public SchoolYear createSchoolYear(RegisterSchoolYearReqVO request) {
        try {
            return this.repository.save(SchoolYear
                    .builder()
                    .courseId(request.getCourseId())
                    .instructorId(request.getInstructorId())
                    .year(request.getYear())
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al crear el periodo curso/instructor.");
        }
    }

    @Override
    public void updateSchoolYear(UpdateSchoolYearReqVO request) {
        try {
            this.repository.save(SchoolYear
                    .builder()
                    .id(request.getId())
                    .courseId(request.getCourseId())
                    .instructorId(request.getInstructorId())
                    .year(request.getYear())
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al actualizar el periodo curso/instructor.");
        }
    }

    @Override
    public void deleteSchoolYear(Integer id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al eliminar el periodo curso/instructor.");
        }
    }
}
