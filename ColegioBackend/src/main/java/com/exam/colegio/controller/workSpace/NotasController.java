package com.exam.colegio.controller.workspace;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/notas")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class NotasController {

}
