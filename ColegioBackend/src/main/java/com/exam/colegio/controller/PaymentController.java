package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IFatherDAO;
import com.exam.colegio.dao.IMotherDAO;
import com.exam.colegio.dao.IStudentDAO;

import com.exam.colegio.service.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PaymentController {

        @PostMapping("/processPaymentForEnrollment")
        public void processPaymentForEnrollment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }

        @PostMapping("/processMonthlyPayment")
        public void processMonthlyPayment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }

        private MessageValidator dniRegistrationValidator(String dniStudent, String dniMother, String dniFather) {
                if (dniStudent == null && (dniFather == null || dniMother == null)) {
                        return MessageValidator.builder().status(false)
                                        .message(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DNI NULL"))
                                        .build();
                }
                if (Optional.ofNullable(dniStudent).orElse("").isEmpty()) {
                        return MessageValidator.builder().status(false).message(
                                        ResponseEntity.status(HttpStatus.NOT_FOUND).body("STUDENT DNI NOT FOUND"))
                                        .build();
                }
                if (Optional.ofNullable(dniMother).orElse("").isEmpty()
                                && Optional.ofNullable(dniFather).orElse("").isEmpty()) {
                        return MessageValidator.builder().status(false).message(
                                        ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO PARENT WITH VALID DNI"))
                                        .build();
                }
                if (!isEightDigitDni.test(dniStudent)
                                || (!isEightDigitDni.test(dniMother) && !isEightDigitDni.test(dniFather))) {
                        return MessageValidator
                                        .builder().status(false).message(ResponseEntity
                                                        .status(HttpStatus.UNPROCESSABLE_ENTITY).body("DNI INVALID"))
                                        .build();
                }
                return MessageValidator.builder().status(true).build();
        }

        private final Predicate<String> isEightDigitDni = dni -> Optional.ofNullable(dni).filter(d -> d.length() == 8)
                        .isPresent();

        private final IFatherDAO fatherDAO;
        private final IMotherDAO motherDAO;
        private final IStudentDAO studentDAO;
        private final IEnrollmentDAO enrollmentDAO;
        private final StudentService studentService;
        private final EnrollmentService enrollmentService;
        private final PersonService personService;
        private final FatherService fatherService;
        private final MotherService motherService;
        private final EnrollmentStudentService enrollmentStudentService;
        private final TypeStatusService typeStatusService;

        @Autowired
        public PaymentController(IFatherDAO fatherDAO, IMotherDAO motherDAO, IStudentDAO studentDAO,
                        IEnrollmentDAO enrollmentDAO, StudentService studentService,
                        EnrollmentService enrollmentService, PersonService personService, FatherService fatherService,
                        MotherService motherService, EnrollmentStudentService enrollmentStudentService,
                        TypeStatusService typeStatusService) {
                this.fatherDAO = fatherDAO;
                this.motherDAO = motherDAO;
                this.studentDAO = studentDAO;
                this.enrollmentDAO = enrollmentDAO;
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.fatherService = fatherService;
                this.motherService = motherService;
                this.enrollmentStudentService = enrollmentStudentService;
                this.typeStatusService = typeStatusService;
        }

}

@Getter
@Builder
class MessageValidator {

        private boolean status;
        private ResponseEntity<?> message;

}