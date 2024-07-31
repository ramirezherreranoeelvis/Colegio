package com.exam.colegio.controller;

import com.exam.colegio.dto.StudentDTO;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentStudent;
import com.exam.colegio.model.person.Father;
import com.exam.colegio.model.person.Mother;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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

        @GetMapping("/horario-matricula")
        public ResponseEntity<?> getHorario(@RequestParam String dniStudent) {
                var studentOptional = this.studentService.findByDni(dniStudent);
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
                }
                var student = studentOptional.get();
                var grade = student.getGrade();
                var gradeNext = grade.getNextGrade();
                if (gradeNext == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un siguiente grado");
                }
                var enrollmentOptional = this.enrollmentService.findByGrade(gradeNext);
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una matricula actualmente para este grado escolar");
                }
                var horarioDTO = this.enrollmentService.getScheduleByEnrollment(enrollmentOptional.get());
                return ResponseEntity.ok(horarioDTO);
        }

        @GetMapping("/students")
        public ResponseEntity<?> getStudents(@RequestParam String dniParent) {
                Optional<String> typeParentOptional = personService.getTypeParent(dniParent);
                if (typeParentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parent not found");
                }

                String typeParent = typeParentOptional.get();
                List<Student> listStudents;

                if (typeParent.equals("father")) {
                        Optional<Father> fatherOptional = fatherService.findByDni(dniParent);
                        if (fatherOptional.isEmpty()) {
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Father not found");
                        }
                        listStudents = fatherOptional.get().getStudents();
                } else {
                        Optional<Mother> motherOptional = motherService.findByDni(dniParent);
                        if (motherOptional.isEmpty()) {
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mother not found");
                        }
                        listStudents = motherOptional.get().getStudents();
                }

                if (listStudents.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No children found");
                }

                List<StudentDTO> listStudentsDTO = listStudents.stream()
                        .map(student -> StudentDTO.builder()
                                .dni(student.getDni())
                                .name(student.getName())
                                .surnamePaternal(student.getSurnamePaternal())
                                .surnameMaternal(student.getSurnameMaternal())
                                .phoneNumber(student.getPhoneNumber())
                                .accessEnabled(student.getAccess().isAccessEnabled())
                                .username(student.getAccess().getUsername())
                                .password(student.getAccess().getPassword())
                                .description(student.getAccess().getDescription())
                                .grade(student.getGrade().getName())
                                .build()
                        ).collect(Collectors.toList());

                return ResponseEntity.ok(listStudentsDTO);
        }

        @PostMapping("/registrar-matricula")
        public ResponseEntity<String> registrarMatricula(@RequestParam String dniStudent, @RequestParam int idEnrollment) {
                var studentOptional = this.studentService.findByDni(dniStudent);
                var enrollmentOptional = this.enrollmentService.findById(idEnrollment);
                //validadion de alumno y matricula existente
                if (studentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
                }
                if (enrollmentOptional.isEmpty()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment Not Found");
                }
                var student = studentOptional.get();
                var enrollment = enrollmentOptional.get();
                //validadocion de grado y alumno
                BiPredicate<Student, Enrollment> validacionGrado = (s, e) -> s.getGrade().getNextGrade().getIdGrade() == e.getGrade().getIdGrade();

                if (validacionGrado.test(student, enrollment)) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esa matricula no es para ese estudiante");
                }

                // validar que no este registrado:
                var enrollmentStudentExist = enrollmentStudentService.isStudentEnrolled(student, enrollment);
                if (enrollmentStudentExist) {
                        ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alumno ya esta registradoa  esta amtricula");
                }

                var enrollmentStudent = this.enrollmentStudentService.save(EnrollmentStudent.builder().student(student).enrollment(enrollment).build());
                if (enrollmentStudent == null) {
                        ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un error al guardar");
                }
                return ResponseEntity.ok("Alumno registrado correctamente");
        }


        private final StudentService studentService;
        private final EnrollmentService enrollmentService;
        private final PersonService personService;
        private final FatherService fatherService;
        private final MotherService motherService;
        private final EnrollmentStudentService enrollmentStudentService;

        @Autowired
        public EnrollmentController(StudentService studentService, EnrollmentService enrollmentService, PersonService personService, FatherService fatherService, MotherService motherService, EnrollmentStudentService enrollmentStudentService) {
                this.studentService = studentService;
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.fatherService = fatherService;
                this.motherService = motherService;
                this.enrollmentStudentService = enrollmentStudentService;
        }

}
