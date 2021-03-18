package com.ltobar.course.repository.custom.impl;

import com.ltobar.course.common.exception.AuthException;
import com.ltobar.course.common.vo.request.UpdateCourseReqVO;
import com.ltobar.course.model.QCourse;
import com.ltobar.course.repository.custom.CustomCourseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
public class CustomCourseRepositoryImpl implements CustomCourseRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void updateCourse(UpdateCourseReqVO request) {
        try {
            JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
            QCourse qCourse = QCourse.course;

            queryFactory
                    .update(qCourse)
                    .set(qCourse.name, request.getName())
                    .set(qCourse.description, request.getDescription())
                    .where(qCourse.id.eq(request.getId()))
                    .execute();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AuthException("Ocurrió un error al ejecutar la consulta de actualziación.");
        }
    }
}
