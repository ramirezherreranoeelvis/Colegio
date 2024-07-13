package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gatomontes
 */
@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "http://localhost:4200/login", allowedHeaders = "*")
public class HorarioController {

        @GetMapping("/actual")
        public ResponseEntity<?> horarioActual(@RequestParam String username) {
                var student = studentDAO.findByUsername(username);

                return ResponseEntity.ok(
                        enrollmentDAO.findAllCoursesByStudentAndEnrollment(student.getDni(), null)
                );
        }

        @Autowired
        private IEnrollmentDAO enrollmentDAO;
        @Autowired
        private IStudentDAO studentDAO;

}
