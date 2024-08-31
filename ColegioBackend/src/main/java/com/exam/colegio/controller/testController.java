package com.exam.colegio.controller;

import com.exam.colegio.model.enrollment.EnrollmentPeriod;
import com.exam.colegio.repository.course.ICourseScheduledRepository;
import com.exam.colegio.repository.enrollment.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RequestMapping("/tessssst")
@RestController
public class testController {

        @GetMapping
        public ResponseEntity<?> obternetPromedioByIdEnrollment() {
                var enrollment = this.enrollmentRepository.findById(7).get();
                //obtenemos las temporadas

                                var periodos = enrollment.getEnrollmentPeriods().stream().map(EnrollmentPeriod::getPeriod).collect(Collectors.toList());
                //                System.out.println(periodos.size());
                //obtenemos cursos
                //                var cursosProgramados = enrollment.getCourseScheduleds();
                //                System.out.println(cursosProgramados.size());
                return ResponseEntity.ok(periodos);
        }

        private final ICourseScheduledRepository courseScheduledRepository;
        private final IEnrollmentRepository enrollmentRepository;

        @Autowired
        public testController(ICourseScheduledRepository courseScheduledRepository, IEnrollmentRepository enrollmentRepository) {
                this.courseScheduledRepository = courseScheduledRepository;
                this.enrollmentRepository = enrollmentRepository;
        }

}
