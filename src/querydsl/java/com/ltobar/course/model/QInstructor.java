package com.ltobar.course.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QInstructor is a Querydsl query type for Instructor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInstructor extends EntityPathBase<Instructor> {

    private static final long serialVersionUID = -1536878848L;

    public static final QInstructor instructor = new QInstructor("instructor");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath identification = createString("identification");

    public final StringPath name = createString("name");

    public QInstructor(String variable) {
        super(Instructor.class, forVariable(variable));
    }

    public QInstructor(Path<? extends Instructor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInstructor(PathMetadata metadata) {
        super(Instructor.class, metadata);
    }

}

