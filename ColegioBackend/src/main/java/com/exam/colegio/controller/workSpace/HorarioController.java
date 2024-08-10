package com.exam.colegio.controller.workspace;

import com.exam.colegio.dao.enrollment.IEnrollmentDAO;
import com.exam.colegio.dao.enrollment.IEnrollmentStudentDAO;
import com.exam.colegio.dao.enrollment.ISeasonDAO;
import com.exam.colegio.dao.person.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gatomontes
 */
@RestController
@RequestMapping("/horario")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HorarioController {

        @GetMapping("/temporadas")
        public ResponseEntity<?> getTemporadas(@RequestParam String dniStudent) {
                var studentOptional = this.studentDAO.findByDni(dniStudent);
                var student = studentOptional.get();
                var seasons = this.studentDAO.findAllSeasonByStudent(student);
                return ResponseEntity.ok(seasons);
        }

        @GetMapping("/horario")
        public ResponseEntity<?> getHorario(@RequestParam int idSeason, @RequestParam String dniStudent) {
                var studentOptional = this.studentDAO.findByDni(dniStudent);
                var student = studentOptional.get();
                var seasonOptional = this.seasonDAO.findById(idSeason);
                var season = seasonOptional.get();
                var enrollmentOptional = enrollmentDAO.findBySeasonAndByStudent(season, student);
                return ResponseEntity.ok(enrollmentDAO.getScheduleByEnrollment(enrollmentOptional.get()).getWeekHorario());
        }

        private final IEnrollmentDAO enrollmentDAO;
        private final IStudentDAO studentDAO;
        private final IEnrollmentStudentDAO enrollmentStudentDAO;
        private final ISeasonDAO seasonDAO;

        @Autowired
        public HorarioController(ISeasonDAO seasonDAO, IEnrollmentStudentDAO enrollmentStudentDAO, IStudentDAO studentDAO, IEnrollmentDAO enrollmentDAO) {
                this.seasonDAO = seasonDAO;
                this.enrollmentStudentDAO = enrollmentStudentDAO;
                this.studentDAO = studentDAO;
                this.enrollmentDAO = enrollmentDAO;
        }

}
