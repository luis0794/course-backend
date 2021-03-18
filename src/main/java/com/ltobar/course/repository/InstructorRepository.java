package com.ltobar.course.repository;


import com.ltobar.course.model.Instructor;
import com.ltobar.course.repository.custom.CustomInstructorRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>, CustomInstructorRepository {

}
