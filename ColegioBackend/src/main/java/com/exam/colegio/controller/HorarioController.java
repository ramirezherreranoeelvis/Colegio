package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gatomontes
 */
@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class HorarioController {

        @GetMapping("/actual")
        public ResponseEntity<?> horarioActual(@RequestParam String username) {
                //find -> Student n' verify
                var studentOptional = studentDAO.findByUsername(username);
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
                }

                var student = studentOptional.get();
                Integer idStudent = student.getIdPerson();

                //find -> enrollment -> id
                var enrollmentStudents = student.getEnrollmentStudents();
                if (enrollmentStudents.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No enrollments found for student");
                }

                var lastEnrollment = enrollmentStudents.get(enrollmentStudents.size() - 1).getEnrollment();
                var idEnrollment = lastEnrollment.getIdEnrollment();
                var courses = enrollmentDAO.findAllCoursesByStudentAndEnrollment(idStudent, idEnrollment);
                return ResponseEntity.ok(courses);
        }

        @Autowired
        private IEnrollmentDAO enrollmentDAO;
        @Autowired
        private IStudentDAO studentDAO;

}
