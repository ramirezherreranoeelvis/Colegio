package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.content.item.GradeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeTypeRepository extends JpaRepository<GradeType, Integer> {

}
