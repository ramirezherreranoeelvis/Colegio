package com.exam.colegio.controller;

import com.exam.colegio.dao.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gatomontes
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200/login", allowedHeaders = "*")
public class LoginController {

        @GetMapping("/login")
        public ResponseEntity<?> ingresarSistema(@RequestParam String username, @RequestParam String password) {

                if (username.isBlank()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
                }
                var personDTOOptional = personDAO.findByUsername(username, password);

                if (personDTOOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The specified username does not exist.");
                }

                return ResponseEntity.ok(personDTOOptional.get());
        }

        @Autowired
        private IPersonDAO personDAO;

}
