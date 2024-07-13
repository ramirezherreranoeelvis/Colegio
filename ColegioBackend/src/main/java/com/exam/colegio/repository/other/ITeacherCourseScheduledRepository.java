package com.exam.colegio.repository.other;

import com.exam.colegio.entity.other.TeacherCourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherCourseScheduledRepository extends JpaRepository<TeacherCourseScheduled, Integer> {

}
