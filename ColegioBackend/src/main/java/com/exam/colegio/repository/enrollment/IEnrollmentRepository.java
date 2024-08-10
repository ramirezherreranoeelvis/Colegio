package com.exam.colegio.repository.enrollment;

import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.enrollment.Enrollment;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {

        @Query(value = "CALL GetCoursesByStudentAndEnrollment(:dniStudent, :idEnrollment)", nativeQuery = true)
        List<CourseScheduled> findCoursesByStudentAndEnrollment(@Param("dniStudent") String dniStudent,
                                                                @Param("idEnrollment") Integer idEnrollment);

        @Query(value = "CALL GetEnrollmentBySeasonAndStudent(:idSeason, :idStudent)", nativeQuery = true)
        Optional<Enrollment> findBySeasonAndStudent(@Param("idSeason") int idSeason, @Param("idStudent") int idStudent);
}
