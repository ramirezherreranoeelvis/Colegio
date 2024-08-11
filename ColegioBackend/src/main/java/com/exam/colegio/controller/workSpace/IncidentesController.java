package com.exam.colegio.controller.workspace;


import com.exam.colegio.dao.report.IReportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/incidentes")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class IncidentesController {

        @GetMapping
        public List<?> findAllByStudent(@RequestParam String dni) {
                return this.reportDAO.findAllByStudent(dni);
        }

        private final IReportDAO reportDAO;

        @Autowired
        public IncidentesController(IReportDAO reportDAO) {
                this.reportDAO = reportDAO;
        }

}
