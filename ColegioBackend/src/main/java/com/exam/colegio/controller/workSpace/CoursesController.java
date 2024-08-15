package com.exam.colegio.controller.workspace;

import com.exam.colegio.dao.course.ICourseScheduledDAO;
import com.exam.colegio.dao.enrollment.ISeasonDAO;
import com.exam.colegio.dao.person.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class CoursesController {

        @GetMapping
        ResponseEntity<?> x(@RequestParam String dni, @RequestParam String year) {

                var studentOptional = this.studentDAO.findByDni(dni);
                var seasonOptional = this.seasonDAO.findByYear(year);
                if (seasonOptional.isEmpty()){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro una la temporadaseleccionada");
                }
                var student = studentOptional.get();
                var season = seasonOptional.get();
                var lista = this.courseScheduledDAO.obtenerPorStudentYPorTemporada(student, season);
                return ResponseEntity.ok(lista);
        }

        private final ICourseScheduledDAO courseScheduledDAO;
        private final IStudentDAO studentDAO;
        private final ISeasonDAO seasonDAO;

        @Autowired
        public CoursesController(ICourseScheduledDAO courseScheduledDAO, IStudentDAO studentDAO, ISeasonDAO seasonDAO) {
                this.courseScheduledDAO = courseScheduledDAO;
                this.studentDAO = studentDAO;
                this.seasonDAO = seasonDAO;
        }

}
