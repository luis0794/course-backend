package com.ltobar.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @Column(name = "instructor_id", nullable = false)
    @SequenceGenerator(name="instructor_id_seq", allocationSize=1)
    @GeneratedValue(strategy = SEQUENCE, generator = "instructor_id_seq")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String identification;

}
