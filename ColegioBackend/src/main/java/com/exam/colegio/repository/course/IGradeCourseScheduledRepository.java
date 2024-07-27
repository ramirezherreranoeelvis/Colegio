package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.GradeCourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeCourseScheduledRepository extends JpaRepository<GradeCourseScheduled, Integer> {

}
