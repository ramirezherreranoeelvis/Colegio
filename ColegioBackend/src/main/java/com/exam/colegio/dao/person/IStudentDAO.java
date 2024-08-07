package com.exam.colegio.dao.person;

import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.model.person.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentDAO {

        Optional<Student> findByUsername(String username);

        Optional<Student> findByDni(String dni);

        List<Payment> findPendingPaymentsForStudent(Student student);

        List<Season> findAllSeasonByStudent(Student student);

}
