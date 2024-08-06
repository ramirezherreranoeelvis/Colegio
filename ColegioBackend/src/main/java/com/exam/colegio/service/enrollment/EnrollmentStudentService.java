package com.exam.colegio.service;

import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentStudent;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.enrollment.IEnrollmentStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentStudentService {

        @Autowired
        private IEnrollmentStudentRepository enrollmentStudentRepository;

        public EnrollmentStudent save(EnrollmentStudent enrollmentStudent) {
                return enrollmentStudentRepository.save(enrollmentStudent);
        }


        public Optional<EnrollmentStudent> findByStudentAndEnrollment(Student student, Enrollment enrollment) {
                return this.enrollmentStudentRepository.findAll().stream()
                        .filter(es -> es.getStudent().getIdPerson() == student.getIdPerson() &&
                                      es.getEnrollment().getIdEnrollment() == enrollment.getIdEnrollment()
                        ).findFirst();
        }
        //encontrr si ya existe el estudiante mregistradoa  aesa matricula
        public boolean isStudentEnrolled(Student student, Enrollment enrollment) {
                return this.enrollmentStudentRepository.findAll().stream()
                        .anyMatch(es -> es.getStudent().getIdPerson() == student.getIdPerson() &&
                                        es.getEnrollment().getIdEnrollment() == enrollment.getIdEnrollment());
        }

        public EnrollmentStudent update(EnrollmentStudent enrollmentStudent) {
                return enrollmentStudentRepository.save(enrollmentStudent);
        }

}
