package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.dto.CourseHorarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gatomontes
 */
public class HorarioController {

        @Autowired
        private IEnrollmentDAO enrollmentDAO;
        @Autowired
        private IStudentDAO studentDAO;

        public List<CourseHorarioDTO> horario(@RequestParam String username) {
                var student = studentDAO.findByUsername(username);
                return enrollmentDAO.findAllCoursesByStudentAndEnrollment(student.getDni(), null);
        }

}
