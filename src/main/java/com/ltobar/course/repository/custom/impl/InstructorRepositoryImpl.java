package com.ltobar.course.repository.custom.impl;


import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.UpdateInstructorReqVO;
import com.ltobar.course.model.Instructor;
import com.ltobar.course.model.QInstructor;
import com.ltobar.course.repository.custom.CustomInstructorRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
public class InstructorRepositoryImpl implements CustomInstructorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private QInstructor qInstructor = QInstructor.instructor;
    private JPAQuery<Instructor> query;
    private JPAUpdateClause queryUpdate;

    @Override
    public void updateInstructor(UpdateInstructorReqVO request) {
        try {
            this.initQuery(Boolean.TRUE);

            this.queryUpdate
                    .set(this.qInstructor.name, request.getName())
                    .set(this.qInstructor.identification, request.getIdentification())
                    .where(this.qInstructor.id.eq(request.getId()))
                    .execute();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error en la consulta de actualización.");
        }
    }

    private void initQuery(Boolean isUpdate) {
        this.qInstructor = QInstructor.instructor;

        if (isUpdate) {
            JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
            queryUpdate = queryFactory.update(this.qInstructor);
        } else {
            this.query = new JPAQuery<>(this.entityManager);
            this.query.from(this.qInstructor);
        }
    }

}
