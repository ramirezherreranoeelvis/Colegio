package com.exam.colegio.entity.enrollment;

import com.exam.colegio.entity.person.Student;
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
