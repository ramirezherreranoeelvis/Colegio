package com.exam.colegio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Requisitos para matricularse, estar registrado en el sistema y tener permiso
 * osea estar trasladado ya matriculado presencialmente porprimera vez
 * la priera matricula es presencial ya sea si desea regresar por traslado
 */
@RestController
@RequestMapping("enrollment")
@CrossOrigin(origins = "http://localhost:4200/login", allowedHeaders = "*")
public class EnrollmentController {



}
