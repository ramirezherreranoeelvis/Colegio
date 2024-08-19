package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.content.SessionAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gatomontes
 */
@Repository
public interface ISessionAttendanceRepository extends JpaRepository<SessionAttendance, Integer> {

}
