package com.ltobar.course.repository;

import com.ltobar.course.model.SchoolYear;
import com.ltobar.course.repository.custom.CustomSchoolYearRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer>, CustomSchoolYearRepository {
}
