package com.exam.colegio.controller.parent;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exam.colegio.dto.MatriculaRegistrarDTO;
import com.exam.colegio.dto.StudentRegistrarMatriculaDTO;
import com.exam.colegio.model.person.Father;
import com.exam.colegio.model.person.Mother;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.service.EnrollmentService;
import com.exam.colegio.service.FatherService;
import com.exam.colegio.service.MotherService;
import com.exam.colegio.service.PersonService;

@RestController
@RequestMapping("/parent")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ParentController {

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

                return ResponseEntity.ok(listStudents.stream().map(student -> {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        var enrollmentOptional = this.enrollmentService.findByGrade(student.getGrade().getNextGrade());
                        MatriculaRegistrarDTO enrollmentDTO = null;
                        if (enrollmentOptional.isPresent()) {
                                var enrollment = enrollmentOptional.get();
                                enrollmentDTO = MatriculaRegistrarDTO.builder()
                                                .idEnrollment(enrollment.getIdEnrollment())
                                                .startDate(formato.format(enrollment.getSeason().getStartDate()))
                                                .nameGrade(enrollment.getGrade().getName())
                                                .vacancies(enrollment.getVacancies()).enrolled(enrollment.getEnrolled())
                                                .cost(enrollment.getCost()).monthlyFee(enrollment.getMonthlyFee())
                                                .build();
                        }
                        return StudentRegistrarMatriculaDTO.builder().dni(student.getDni()).name(student.getName())
                                        .surnamePaternal(student.getSurnamePaternal())
                                        .surnameMaternal(student.getSurnameMaternal())
                                        .phoneNumber(student.getPhoneNumber())
                                        .accessEnabled(student.getAccess().isAccessEnabled())
                                        .username(student.getAccess().getUsername())
                                        .password(student.getAccess().getPassword())
                                        .description(student.getAccess().getDescription())
                                        .grade(student.getGrade().getName()).nextEnrollment(enrollmentDTO).build();
                }).toList());
        }

        private final EnrollmentService enrollmentService;
        private final PersonService personService;
        private final FatherService fatherService;
        private final MotherService motherService;

        @Autowired
        public ParentController(EnrollmentService enrollmentService, PersonService personService,
                        FatherService fatherService, MotherService motherService) {
                this.enrollmentService = enrollmentService;
                this.personService = personService;
                this.fatherService = fatherService;
                this.motherService = motherService;
        }
}