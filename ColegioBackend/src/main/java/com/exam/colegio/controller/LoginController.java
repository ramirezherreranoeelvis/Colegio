package com.exam.colegio.controller;

import com.exam.colegio.entity.person.Person;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class LoginController {

        @GetMapping("/metodo")
        public Person ingresarSistema(String username, String Password) {
                return null;
        }

}
