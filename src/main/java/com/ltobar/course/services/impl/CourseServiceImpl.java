package com.ltobar.course.services.impl;

import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.RegisterCourseReqVO;
import com.ltobar.course.common.vo.request.UpdateCourseReqVO;
import com.ltobar.course.model.Course;
import com.ltobar.course.repository.CourseRepository;
import com.ltobar.course.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;


    @Override
    public List<Course> findAll() {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar todos los cursos.");
        }
    }

    @Override
    public Course findById(Integer id) {
        try {
            return this.repository.findById(id)
                    .orElseThrow(() -> new AuthException("Curso no encontrado."));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar el curso.");
        }
    }

    @Override
    public Course createCourse(RegisterCourseReqVO request) {
        try {
            return this.repository
                    .save(Course
                            .builder()
                            .name(request.getName())
                            .description(request.getDescription())
                            .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al crear el curso.");
        }
    }

    @Override
    public void updateCourse(UpdateCourseReqVO request) {
        try {
            this.repository
                    .save(Course
                            .builder()
                            .id(request.getId())
                            .name(request.getName())
                            .description(request.getDescription())
                            .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al actualizar el curso.");
        }
    }

    @Override
    public void deleteCourse(Integer id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al eliminar el curso.");
        }
    }
}
