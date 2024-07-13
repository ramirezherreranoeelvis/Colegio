package com.exam.colegio.repository.enrollment;

import com.exam.colegio.entity.course.GradeCourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeCourseScheduledRepository extends JpaRepository<GradeCourseScheduled, Integer> {

}
