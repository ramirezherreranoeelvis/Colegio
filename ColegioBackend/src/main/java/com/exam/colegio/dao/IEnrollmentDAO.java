package com.exam.colegio.dao;

import com.exam.colegio.dto.HorarioDTO;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.other.Grade;
import com.exam.colegio.model.person.Student;

import java.util.Optional;
public interface IEnrollmentDAO {

        Optional<Enrollment> findById(int idEnrollment);

        Optional<Enrollment> addRegisterStudent(Student student, Enrollment enrollment);

        HorarioDTO getScheduleByEnrollment(Enrollment enrollment);

        Optional<Enrollment> findByGrade(Grade grade);

        Enrollment update(Enrollment enrollment);

}
