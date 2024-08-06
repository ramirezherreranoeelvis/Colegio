package com.exam.colegio.repository.enrollment;

import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentStudent;
import com.exam.colegio.model.person.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEnrollmentStudentRepository extends JpaRepository<EnrollmentStudent, Integer> {

}
