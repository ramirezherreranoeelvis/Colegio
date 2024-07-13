package com.exam.colegio.repository.enrollment;

import com.exam.colegio.entity.enrollment.EnrollmentStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentStudentRepository extends JpaRepository<EnrollmentStudent, Integer> {

}
