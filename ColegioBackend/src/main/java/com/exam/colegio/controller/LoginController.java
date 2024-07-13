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
        public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {

                if (username.isBlank()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
                }
                var person = personDAO.findByUsername(username, password);

                if (person == null) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The specified username does not exist.");
                }

                return ResponseEntity.ok(person);
        }

        @Autowired
        private IPersonDAO personDAO;

}
