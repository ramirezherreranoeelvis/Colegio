package com.exam.colegio.controller;

import com.exam.colegio.repository.course.*;
import com.exam.colegio.repository.enrollment.*;
import com.exam.colegio.repository.other.IGradeRepository;
import com.exam.colegio.repository.person.IStudentRepository;
import com.exam.colegio.repository.person.ITeacherRepository;
import com.exam.colegio.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/data")
public class TestController {



        @GetMapping
        public List<?> data() {
                var idEnrollment = 7;
                return null;
        }

        @Autowired
        private EnrollmentService enrollmentService;

        //course
        private ICourseRepository courseRepository;
        private ICourseScheduledRepository courseScheduledRepository;
        private IGradeCourseScheduledRepository gradeCourseScheduledRepository;
        private IGradeTypeRepository gradeTypeRepository;
        private IStudentAttendanceCourseScheduledRepository studentAttendanceCourseScheduledRepository;
        //enrollment
        private IEnrollmentRepository enrollmentRepository;
        private IEnrollmentStudentRepository enrollmentStudentRepository;
        private IPaymentRepository paymentRepository;
        private ISeasonRepository seasonRepository;
        private ITypeStatusRepository typeStatusRepository;
        //other
        private IGradeRepository gradeRepository;
        //person
        private IStudentRepository studentRepository;
        private ITeacherRepository teacherRepository;
        //report


        public TestController(ITeacherRepository teacherRepository, IStudentRepository studentRepository, IGradeRepository gradeRepository, ITypeStatusRepository typeStatusRepository, ISeasonRepository seasonRepository, IPaymentRepository paymentRepository, IEnrollmentStudentRepository enrollmentStudentRepository, IEnrollmentRepository enrollmentRepository, IStudentAttendanceCourseScheduledRepository studentAttendanceCourseScheduledRepository, IGradeTypeRepository gradeTypeRepository, IGradeCourseScheduledRepository gradeCourseScheduledRepository, ICourseScheduledRepository courseScheduledRepository, ICourseRepository courseRepository) {
                this.teacherRepository = teacherRepository;
                this.studentRepository = studentRepository;
                this.gradeRepository = gradeRepository;
                this.typeStatusRepository = typeStatusRepository;
                this.seasonRepository = seasonRepository;
                this.paymentRepository = paymentRepository;
                this.enrollmentStudentRepository = enrollmentStudentRepository;
                this.enrollmentRepository = enrollmentRepository;
                this.studentAttendanceCourseScheduledRepository = studentAttendanceCourseScheduledRepository;
                this.gradeTypeRepository = gradeTypeRepository;
                this.gradeCourseScheduledRepository = gradeCourseScheduledRepository;
                this.courseScheduledRepository = courseScheduledRepository;
                this.courseRepository = courseRepository;
        }

}