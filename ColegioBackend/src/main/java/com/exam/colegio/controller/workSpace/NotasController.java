package com.exam.colegio.controller.workspace;

import com.exam.colegio.dao.person.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/notas")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*"
)
@RestController
public class NotasController {

        @GetMapping("/promedios")
        public ResponseEntity<?> obtenerPromediosGenerales(@RequestParam String dniStudent, @RequestParam String year) {
                var studentOptional = this.studentDAO.findByDni(dniStudent);
                return null;
        }

        @Autowired
        private IStudentDAO studentDAO;

}
