package com.exam.colegio.repository.course;

import com.exam.colegio.entity.course.CourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseScheduledRepository extends JpaRepository<CourseScheduled, Integer> {

}
