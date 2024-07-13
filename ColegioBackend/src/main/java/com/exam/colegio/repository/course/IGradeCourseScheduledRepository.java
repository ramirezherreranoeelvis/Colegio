package com.exam.colegio.repository.course;

import com.exam.colegio.entity.course.GradeCourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<GradeCourseScheduled, Integer> {

}
