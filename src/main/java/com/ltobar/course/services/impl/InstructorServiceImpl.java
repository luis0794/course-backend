package com.ltobar.course.services.impl;


import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.RegisterInstructorReqVO;
import com.ltobar.course.common.vo.request.UpdateInstructorReqVO;
import com.ltobar.course.model.Instructor;
import com.ltobar.course.repository.InstructorRepository;
import com.ltobar.course.services.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    @Resource
    private InstructorRepository repository;

    @Override
    public List<Instructor> findAll() {
        try {
            return this.repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar todos los instructores.");
        }
    }

    @Override
    public Instructor findById(Integer id) {
        try {
            return this.repository.findById(id)
                    .orElseThrow(() -> new AuthException("Instructor no encontrado."));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al buscar el instructor.");
        }
    }

    @Override
    public Instructor createInstructor(RegisterInstructorReqVO request) throws AuthException {
        try {
            return this.repository.save(Instructor
                    .builder()
                    .name(request.getName())
                    .identification(request.getIdentification())
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al crear el instructor.");
        }
    }

    @Override
    public void updateInstructor(UpdateInstructorReqVO request) {
        try {
            this.repository.
                    save(Instructor
                            .builder()
                            .id(request.getId())
                            .identification(request.getIdentification())
                            .name(request.getName())
                            .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al actualizar el instructor.");
        }
    }

    @Override
    public void deleteInstructor(Integer id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al eliminar el instructor.");
        }
    }

}
