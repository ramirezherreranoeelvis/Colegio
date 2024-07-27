package com.exam.colegio.controller;

import com.exam.colegio.dao.IEnrollmentDAO;
import com.exam.colegio.dao.IFatherDAO;
import com.exam.colegio.dao.IMotherDAO;
import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.model.person.Student;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "http://localhost:4200/login", allowedHeaders = "*")
public class PaymentController {


        @GetMapping("/registerStudentEnrollment")
        public ResponseEntity<?> registerStudentEnrollment(String dniStudent, String dniMother, String dniFather, Integer idEnrollment) {
                var messageDniValidator = dniRegistrationValidator(dniStudent, dniMother, dniFather);
                if (!messageDniValidator.isStatus()) {
                        return messageDniValidator.getMessage();
                }
                //buscar padres y estudiante existentes:
                var motherOptional = motherDAO.findByDni(dniMother);
                var studentOptional = studentDAO.findByDni(dniStudent);
                var fatherOptional = fatherDAO.findByDni(dniFather);
                var existsParents = fatherOptional.isPresent() || motherOptional.isPresent();
                if (!existsParents) {
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No existe un Padre o Madre con permiso de registrar matricula");
                }

                // empezamos el registro a la matrícula
                var enrollmentOptional = enrollmentDAO.findById(idEnrollment);
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment Not Found");
                }
                // si no hay estudiante entonces lo registramos
                Student student = null;
                if (studentOptional.isEmpty()) {
                        student = new Student();
                }
                var enrollment = enrollmentOptional.get();
                var enrollmentUpdateOptional = this.enrollmentDAO.addRegisterStudent(student, enrollment);

                return enrollmentUpdateOptional.isEmpty()
                        ? ResponseEntity.status(HttpStatus.CONFLICT).body("Enrollment Exists")
                        : ResponseEntity.ok(enrollment);

        }


        @PostMapping("/processPaymentForEnrollment")
        public void processPaymentForEnrollment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }

        @PostMapping("/processMonthlyPayment")
        public void processMonthlyPayment() {
                throw new UnsupportedOperationException("Este método aún no está implementado");
        }


        private final IFatherDAO fatherDAO;
        private final IMotherDAO motherDAO;
        private final IStudentDAO studentDAO;
        private final IEnrollmentDAO enrollmentDAO;
        private final Predicate<String> isEightDigitDni = dni -> Optional.ofNullable(dni).filter(d -> d.length() == 8).isPresent();

        @Autowired
        public PaymentController(IFatherDAO fatherDAO, IMotherDAO motherDAO, IStudentDAO studentDAO, IEnrollmentDAO enrollmentDAO) {
                this.fatherDAO = fatherDAO;
                this.motherDAO = motherDAO;
                this.studentDAO = studentDAO;
                this.enrollmentDAO = enrollmentDAO;
        }

        private MessageValidator dniRegistrationValidator(String dniStudent, String dniMother, String dniFather) {
                if (dniStudent == null && (dniFather == null || dniMother == null)) {
                        return MessageValidator.builder().status(false).message(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DNI NULL")).build();
                }
                if (Optional.ofNullable(dniStudent).orElse("").isEmpty()) {
                        return MessageValidator.builder().status(false).message(ResponseEntity.status(HttpStatus.NOT_FOUND).body("STUDENT DNI NOT FOUND")).build();
                }
                if (Optional.ofNullable(dniMother).orElse("").isEmpty() && Optional.ofNullable(dniFather).orElse("").isEmpty()) {
                        return MessageValidator.builder().status(false).message(ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO PARENT WITH VALID DNI")).build();
                }
                if (!isEightDigitDni.test(dniStudent) || (!isEightDigitDni.test(dniMother) && !isEightDigitDni.test(dniFather))) {
                        return MessageValidator.builder().status(false).message(ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("DNI INVALID")).build();
                }
                return MessageValidator.builder().status(true).build();
        }

}

@Getter
@Builder
class MessageValidator {

        private boolean status;
        private ResponseEntity<?> message;

}