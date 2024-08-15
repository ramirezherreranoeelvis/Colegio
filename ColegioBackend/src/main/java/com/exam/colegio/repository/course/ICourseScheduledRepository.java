package com.exam.colegio.repository.course;

import com.exam.colegio.model.course.CourseScheduled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseScheduledRepository extends JpaRepository<CourseScheduled, Integer> {

        @Query(value = "CALL GetCoursesByStudentAndEnrollment(:dniStudent, :idEnrollment)", nativeQuery = true)
        List<CourseScheduled> findCoursesByStudentAndEnrollment(@Param("dniStudent") String dniStudent,
                                                                @Param("idEnrollment") Integer idEnrollment);

        @Query(value = "CALL usp_findCoursesByDniStudentByYear(:student, :year)", nativeQuery = true)
        List<CourseScheduled> obtenerPorStudentYPorTemporada(@Param("student") String student,
                                                             @Param("year") String season);

}
