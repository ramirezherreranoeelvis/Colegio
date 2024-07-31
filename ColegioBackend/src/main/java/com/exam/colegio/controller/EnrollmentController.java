package com.exam.colegio.controller;

import com.exam.colegio.service.EnrollmentService;
import com.exam.colegio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * <h4>Requisitos para registrar matrícula</h4>
 * <ul>
 * <li>Estar registrado en el sistema</li>
 * <li>Estar actualmente trasladado aquí</li>
 * </ul>
 */
@RestController
@RequestMapping("/enrollment")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EnrollmentController {

        @GetMapping("/horario-matricula")
        public ResponseEntity<?> getHorario(@RequestParam String dniStudent) {
                var studentOptional = this.studentService.findByDni(dniStudent);
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
                }
                var student = studentOptional.get();
                var grade = student.getGrade();
                var gradeNext = grade.getNextGrade();
                if (gradeNext == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un siguiente grado");
                }
                var enrollmentOptional = this.enrollmentService.findByGrade(gradeNext);
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una matricula actualmente para este grado escolar");
                }
                var horarioDTO = this.enrollmentService.getScheduleByEnrollment(enrollmentOptional.get());
                return ResponseEntity.ok(horarioDTO);
        }

        private final StudentService studentService;
        private final EnrollmentService enrollmentService;

        @Autowired
        public EnrollmentController(StudentService studentService, EnrollmentService enrollmentService) {
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
        }

}
