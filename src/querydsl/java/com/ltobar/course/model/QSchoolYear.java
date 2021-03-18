package com.ltobar.course.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchoolYear is a Querydsl query type for SchoolYear
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchoolYear extends EntityPathBase<SchoolYear> {

    private static final long serialVersionUID = 1266975796L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSchoolYear schoolYear = new QSchoolYear("schoolYear");

    public final QCourse course;

    public final NumberPath<Integer> courseId = createNumber("courseId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QInstructor instructor;

    public final NumberPath<Integer> instructorId = createNumber("instructorId", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QSchoolYear(String variable) {
        this(SchoolYear.class, forVariable(variable), INITS);
    }

    public QSchoolYear(Path<? extends SchoolYear> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSchoolYear(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSchoolYear(PathMetadata metadata, PathInits inits) {
        this(SchoolYear.class, metadata, inits);
    }

    public QSchoolYear(Class<? extends SchoolYear> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourse(forProperty("course")) : null;
        this.instructor = inits.isInitialized("instructor") ? new QInstructor(forProperty("instructor")) : null;
    }

}

