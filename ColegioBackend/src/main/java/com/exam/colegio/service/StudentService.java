package com.exam.colegio.service;

import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.person.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Gatomontes
 */
@Service
public class StudentService implements IStudentDAO {

        @Override
        public Optional<Student> findByUsername(String username) {
                return studentRepository.findByAccessUsername(username);
        }

        @Override
        public Optional<Student> findByDni(String dni) {
                return studentRepository.findByDni(dni);
        }

        public List<Payment> findPendingPaymentsForStudent(Student student) {
                return student.getEnrollmentStudents().stream()
                        .flatMap(enrollmentStudent -> enrollmentStudent.getPayments().stream())
                        .filter(payment -> payment.getTypeStatus().getIdTypeStatus() == 2) // Tipo "pendiente"
                        .collect(Collectors.toList());
        }


        private final IStudentRepository studentRepository;

        @Autowired
        public StudentService(IStudentRepository studentRepository) {
                this.studentRepository = studentRepository;
        }

}
