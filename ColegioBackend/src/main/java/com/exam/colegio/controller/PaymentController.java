package com.exam.colegio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {

        @PostMapping("/registerStudentEnrollment")
        public void registerStudentEnrollment() {

        }

        @PostMapping("/processPaymentForEnrollment")
        public void processPaymentForEnrollment() {

        }

        @PostMapping("/processMonthlyPayment")
        public void processMonthlyPayment() {

        }

}
