package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IFatherDAO;
import com.exam.colegio.dao.IMotherDAO;
import com.exam.colegio.dao.IStudentDAO;

import com.exam.colegio.dto.PagoDTO;
import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.service.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PaymentController {

        @PostMapping("/processPaymentForEnrollment")
        public ResponseEntity<?> processPaymentForEnrollment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }

        @PostMapping("/processMonthlyPayment")
        public ResponseEntity<?> processMonthlyPayment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }

        @GetMapping("/pagosPendientes")
        public ResponseEntity<?> pagosPendientes(@RequestParam String dniStudent) {
                var studentOptional = this.studentService.findByDni(dniStudent);
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found Student");
                }
                var paymentList = this.studentService.findPendingPaymentsForStudent(studentOptional.get());
                var paymentListDTO = paymentList.stream().map(payment -> {
                        return new PagoDTO(payment.getIdPayment(), payment.getPay(), payment.getDescription());
                }).toList();
                return ResponseEntity.ok(paymentListDTO);
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

        private final StudentService studentService;
        private final EnrollmentService enrollmentService;
        private final PersonService personService;
        private final EnrollmentStudentService enrollmentStudentService;
        private final PaymentService paymentService;

        @Autowired
        public PaymentController(StudentService studentService, EnrollmentService enrollmentService, PersonService personService, EnrollmentStudentService enrollmentStudentService, PaymentService paymentService) {
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.enrollmentStudentService = enrollmentStudentService;
                this.paymentService = paymentService;
        }

}

@Getter
@Builder
class MessageValidator {

        private boolean status;
        private ResponseEntity<?> message;

}