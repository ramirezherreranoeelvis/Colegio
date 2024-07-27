package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.StudentAttendanceCourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gatomontes
 */
@Repository
public interface IStudentAttendanceCourseScheduledRepository extends JpaRepository<StudentAttendanceCourseScheduled, Integer> {

}
