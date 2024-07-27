package com.exam.colegio.repository.enrollment;

import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.enrollment.Enrollment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {

        @Query("SELECT cs FROM Enrollment e JOIN e.enrollmentStudents es JOIN e.courseScheduleds cs "
               + "WHERE es.student.dni = :dniStudent AND e.idEnrollment = :idEnrollment")
        List<CourseScheduled> findCoursesByStudentAndEnrollment(@Param("dniStudent") String dniStudent,
                                                                @Param("idEnrollment") Integer idEnrollment);

}
