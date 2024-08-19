package com.exam.colegio.controller.enrollment;

import com.exam.colegio.dao.enrollment.ISeasonDAO;
import com.exam.colegio.dao.person.IStudentDAO;
import com.exam.colegio.dto.TemporadaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/temporada")
@RestController
public class SeasonController {

        @GetMapping
        public List<TemporadaDTO> findAllByStudent(@RequestParam String dniStudent) {
                var studentOptional = this.studentDAO.findByDni(dniStudent);
                var student = studentOptional.get();
                return this.seasonDAO.findByStudent(student);
        }

        private final ISeasonDAO seasonDAO;
        private final IStudentDAO studentDAO;

        @Autowired
        public SeasonController(ISeasonDAO seasonDAO, IStudentDAO studentDAO) {
                this.seasonDAO = seasonDAO;
                this.studentDAO = studentDAO;
        }

}
