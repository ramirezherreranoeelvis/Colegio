package com.exam.colegio.controller;

import com.exam.colegio.dto.PagoDTO;
import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.model.enrollment.TypeStatus;
import com.exam.colegio.service.enrollment.EnrollmentService;
import com.exam.colegio.service.enrollment.EnrollmentStudentService;
import com.exam.colegio.service.enrollment.PaymentService;
import com.exam.colegio.service.enrollment.TypeStatusService;
import com.exam.colegio.service.person.PersonService;
import com.exam.colegio.service.person.StudentService;
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
        public ResponseEntity<?> processPaymentForEnrollment(@RequestParam int paymentRequest) {
                Optional<Payment> optionalPayment = paymentService.findById(paymentRequest);

                if (optionalPayment.isPresent()) {
                        Payment payment = optionalPayment.get();

                        TypeStatus canceledStatus = typeStatusService.findById(1).orElseThrow(() ->
                                new RuntimeException("Tipo de estado no encontrado")
                        );

                        payment.setTypeStatus(canceledStatus);

                        paymentService.save(payment);

                        return ResponseEntity.ok("Pago cancelado exitosamente.");
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pago no encontrado.");
                }
        }

        @PostMapping("/processMonthlyPayment")
        public ResponseEntity<?> processMonthlyPayment(@RequestParam int paymentRequest) {
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
        private final TypeStatusService typeStatusService;

        @Autowired
        public PaymentController(StudentService studentService, EnrollmentService enrollmentService, PersonService personService, EnrollmentStudentService enrollmentStudentService, PaymentService paymentService, TypeStatusService typeStatusService) {
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.enrollmentStudentService = enrollmentStudentService;
                this.paymentService = paymentService;
                this.typeStatusService = typeStatusService;
        }

}

@Getter
@Builder
class MessageValidator {

        private boolean status;
        private ResponseEntity<?> message;

}