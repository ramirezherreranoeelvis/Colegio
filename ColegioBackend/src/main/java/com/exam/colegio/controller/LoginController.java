package com.exam.colegio.controller;

import com.exam.colegio.entity.person.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class LoginController {

        @GetMapping("/metodo")
        public Person ingresarSistema(@RequestParam String username, @RequestParam String Password) {
                return null;
        }

}
