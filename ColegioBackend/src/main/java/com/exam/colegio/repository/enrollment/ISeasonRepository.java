package com.exam.colegio.repository.enrollment;

import com.exam.colegio.entity.course.GradeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeTypeRepository extends JpaRepository<GradeType, Integer> {

}
