package com.exam.colegio.controller.enrollment;

import com.exam.colegio.dto.MatriculaRegistrarDTO;
import com.exam.colegio.dto.StudentRegistrarMatriculaDTO;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentStudent;
import com.exam.colegio.model.enrollment.Payment;
import com.exam.colegio.model.person.Father;
import com.exam.colegio.model.person.Mother;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiPredicate;


/**
 * <h4>Requisitos para registrar matrícula</h4>
 * <ul>
 * <li>Estar registrado en el sistema</li>
 * <li>Estar actualmente trasladado aquí</li>
 * </ul>
 */
@RestController
@RequestMapping("/enrollment")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EnrollmentController {

        @GetMapping("/horario")
        public ResponseEntity<?> getHorario(@RequestParam int idEnrollment) {
                var enrollmentOptional = this.enrollmentService.findById(idEnrollment);
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una matricula actualmente para este grado escolar");
                }
                var horarioDTO = this.enrollmentService.getScheduleByEnrollment(enrollmentOptional.get());
                return ResponseEntity.ok(horarioDTO.getWeekHorario());
        }

        @GetMapping("/students")
        public ResponseEntity<?> getStudents(@RequestParam String dniParent) {
                var typeParentOptional = personService.getTypeParent(dniParent);
                if (typeParentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent not found");
                }

                var typeParent = typeParentOptional.get();
                List<Student> listStudents;

                if (typeParent.equals("father")) {
                        var fatherOptional = fatherService.findByDni(dniParent);
                        if (fatherOptional.isEmpty()) {
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Father not found");
                        }
                        listStudents = fatherOptional.get().getStudents();
                } else {
                        var motherOptional = motherService.findByDni(dniParent);
                        if (motherOptional.isEmpty()) {
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mother not found");
                        }
                        listStudents = motherOptional.get().getStudents();
                }

                if (listStudents.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No children found");
                }

                return ResponseEntity.ok(listStudents.stream().map(student -> {
                        var formato = new SimpleDateFormat("yyyy-MM-dd");
                        var enrollmentOptional = this.enrollmentService.findByGrade(student.getGrade().getNextGrade());
                        MatriculaRegistrarDTO enrollmentDTO = null;
                        if (enrollmentOptional.isPresent()) {
                                var enrollment = enrollmentOptional.get();
                                enrollmentDTO = MatriculaRegistrarDTO.builder().idEnrollment(enrollment.getIdEnrollment()).startDate(formato.format(enrollment.getSeason().getStartDate())).nameGrade(enrollment.getGrade().getName()).vacancies(enrollment.getVacancies()).enrolled(enrollment.getEnrolled()).cost(enrollment.getCost()).monthlyFee(enrollment.getMonthlyFee()).build();
                        }
                        return StudentRegistrarMatriculaDTO.builder().dni(student.getDni()).name(student.getName()).surnamePaternal(student.getSurnamePaternal()).surnameMaternal(student.getSurnameMaternal()).phoneNumber(student.getPhoneNumber()).accessEnabled(student.getAccess().isAccessEnabled()).username(student.getAccess().getUsername()).password(student.getAccess().getPassword()).description(student.getAccess().getDescription()).grade(student.getGrade().getName()).nextEnrollment(enrollmentDTO).build();
                }).toList());
        }

        @PostMapping("/registrar")
        public ResponseEntity<?> registerStudentEnrollment(@RequestParam String dniStudent, @RequestParam int idEnrollment) {
                var studentOptional = this.studentService.findByDni(dniStudent);
                var enrollmentOptional = this.enrollmentService.findById(idEnrollment);

                //validation de alumno y matrícula existente
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
                }
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment Not Found");
                }
                var student = studentOptional.get();
                var enrollment = enrollmentOptional.get();

                //validation de grado y alumno
                BiPredicate<Student, Enrollment> validationGrade = (s, e) -> s.getGrade().getNextGrade().getIdGrade() == e.getGrade().getIdGrade();

                if (!validationGrade.test(student, enrollment)) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esa matricula no es para ese estudiante");
                }

                // validar que no este registrado:
                var enrollmentStudentExist = enrollmentStudentService.isStudentEnrolled(student, enrollment);
                if (enrollmentStudentExist) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alumno ya esta registradoa  esta amtricula");
                }

                // Obtener los tipos de pago para ponerlos como falta:
                var pendienteOptional = this.typeStatusService.findAll().stream().filter(typeStatus -> typeStatus.getIdTypeStatus() == 2).findFirst();
                if (pendienteOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tipo de estado pendiente no encontrado");
                }
                var pendiente = pendienteOptional.get();

                //creación de lista de pagos
                var payments = new ArrayList<Payment>();

                // creamos el pago de matrícula:
                payments.add(Payment.builder()
                        .typeStatus(pendiente)
                        .pay(enrollment.getCost())
                        .description("Matricula")
                        .build());
                // creamos mensualidades:
                for (int i = 0; i < enrollment.getMonths(); i++) {
                        payments.add(Payment
                                .builder()
                                .typeStatus(pendiente)
                                .pay(enrollment.getMonthlyFee())
                                .description("mensualidad")
                                .build()
                        );
                }

                // crear enrollmentStudent:
                var enrollmentStudent = this.enrollmentStudentService.save(EnrollmentStudent.builder()
                        .student(student)
                        .enrollment(enrollment)
                        .build()
                );

                //resultado:
                var message = new HashMap<String, String>();
                if (enrollmentStudent == null) {
                        message.put("message", "Hubo un error al guardar");
                        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
                }

                payments.forEach(payment -> payment.setEnrollmentStudent(enrollmentStudent));
                enrollmentStudent.setPayments(payments);
                this.enrollmentStudentService.update(enrollmentStudent);

                enrollment.setEnrolled(enrollment.getEnrolled() + 1);
                this.enrollmentService.update(enrollment);

                message.put("message", "Alumno registrado correctamente");
                return ResponseEntity.ok(message);
        }


        private final StudentService studentService;
        private final EnrollmentService enrollmentService;
        private final PersonService personService;
        private final FatherService fatherService;
        private final MotherService motherService;
        private final EnrollmentStudentService enrollmentStudentService;
        private final TypeStatusService typeStatusService;

        @Autowired
        public EnrollmentController(StudentService studentService, EnrollmentService enrollmentService, PersonService personService, FatherService fatherService, MotherService motherService, EnrollmentStudentService enrollmentStudentService, TypeStatusService typeStatusService) {
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.fatherService = fatherService;
                this.motherService = motherService;
                this.enrollmentStudentService = enrollmentStudentService;
                this.typeStatusService = typeStatusService;
        }

        private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(getClass().getName());

}
