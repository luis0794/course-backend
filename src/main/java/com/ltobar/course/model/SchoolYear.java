package com.ltobar.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.SEQUENCE;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school_year", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"course_id", "instructor_id", "year"})
})
public class SchoolYear {

    @Id
    @Column(name = "school_year_id", nullable = false)
    @SequenceGenerator(name="school_year_id_seq", allocationSize=1)
    @GeneratedValue(strategy = SEQUENCE, generator = "school_year_id_seq")
    private Integer id;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "instructor_id", nullable = false)
    private Integer instructorId;

    @Column(nullable = false)
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",
            referencedColumnName = "course_id",
            insertable = false,
            updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id",
            referencedColumnName = "instructor_id",
            insertable = false,
            updatable = false)
    private Instructor instructor;

}
