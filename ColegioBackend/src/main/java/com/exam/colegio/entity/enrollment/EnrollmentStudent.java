package com.exam.colegio.entity.registration;

import com.exam.colegio.entity.person.Person;
import com.exam.colegio.entity.person.Student;
import com.exam.colegio.entity.report.Report;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
@Entity
@Table(name = "enrollmentStudent")
public class EnrollmentStudent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idEnrollmentStudent;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false)
        private Student student;

        @ManyToOne
        @JoinColumn(name = "idEnrollment", nullable = false)
        private Enrollment enrollment;

}
