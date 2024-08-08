package com.exam.colegio.controller.others;

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
public class ScheduledController {

        @GetMapping("/temporadas")
        public ResponseEntity<?> getTemporadas(@RequestParam String dniStudent) {
                var studentOptional = this.studentDAO.findByDni(dniStudent);
                var student = studentOptional.get();
                var seasons = this.studentDAO.findAllSeasonByStudent(student);
                return ResponseEntity.ok(seasons);
        }

        @GetMapping("/horario")
        public ResponseEntity<?> getHorario(@RequestParam int idSeason, @RequestParam String dniStudent) {
                var student = studentDAO.findByDni(dniStudent).get();
                var season = this.seasonDAO.findById(idSeason).get();
                var enrollmentOptional = enrollmentDAO.findBySeasonAndByStudent(season, student);
                return ResponseEntity.ok(enrollmentDAO.getScheduleByEnrollment(enrollmentOptional.get()).getWeekHorario());
        }

        @Autowired
        private IEnrollmentDAO enrollmentDAO;

        @Autowired
        private IStudentDAO studentDAO;
        @Autowired
        private IEnrollmentStudentDAO enrollmentStudentDAO;
        @Autowired
        private ISeasonDAO seasonDAO;

}
