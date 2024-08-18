package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.SessionAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gatomontes
 */
@Repository
public interface ISessionAttendance extends JpaRepository<SessionAttendance, Integer> {

}
