package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IStudentDAO;
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
public class ScheduledController {

        @GetMapping("/actual")
        public ResponseEntity<?> horarioActual(@RequestParam String username) {
                var studentOptional = this.studentDAO.findByUsername(username);

                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
                }

                // get data student
                var student = studentOptional.get();
                var enrollmentStudents = student.getEnrollmentStudents();

                if (enrollmentStudents.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No enrollments found for student");
                }
                //get Last EnrollmentStudent
                var lastIndexEnrollmentStudent = enrollmentStudents.size() - 1;
                var lastEnrollmentStudent = enrollmentStudents.get(lastIndexEnrollmentStudent);

                var lastEnrollment = lastEnrollmentStudent.getEnrollment();
                var horario = this.enrollmentDAO.getScheduleByEnrollment(lastEnrollment);

                return ResponseEntity.ok(horario);
        }

        @Autowired
        private IEnrollmentDAO enrollmentDAO;

        @Autowired
        private IStudentDAO studentDAO;

}
