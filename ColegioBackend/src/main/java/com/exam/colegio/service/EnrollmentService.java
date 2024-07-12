package com.exam.colegio.service;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dto.CourseHorarioDTO;
import com.exam.colegio.repository.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnrollmentService implements IEnrollmentDAO {

        @Override
        public List<CourseHorarioDTO> findAllCoursesByStudentAndEnrollment(Integer dniStudent, Integer idEnrollment) {
                return enrollmentRepository.findAll().stream()
                        .filter(enrollment -> enrollment.getIdEnrollment().equals(idEnrollment))
                        .flatMap(enrollment -> enrollment.getEnrollmentStudents().stream())
                        .filter(enrollmentStudent -> enrollmentStudent.getStudent().getDni().equals(dniStudent))
                        .flatMap(enrollmentStudent -> enrollmentStudent.getEnrollment().getCourseScheduleds().stream())
                        .map(courseScheduled -> CourseHorarioDTO.builder()
                                .name(courseScheduled.getCourse().getName())
                                .startTime(courseScheduled.getStartTime())
                                .endTime(courseScheduled.getEndTime())
                                .day(courseScheduled.getDayOfWeek().getDisplayName())
                                .build()
                        )
                        .toList();
        }

        private final IEnrollmentRepository enrollmentRepository;

        @Autowired
        public EnrollmentService(IEnrollmentRepository enrollmentRepository) {
                this.enrollmentRepository = enrollmentRepository;
        }

}
