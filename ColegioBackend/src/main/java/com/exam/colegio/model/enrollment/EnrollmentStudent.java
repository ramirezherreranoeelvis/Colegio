package com.exam.colegio.model.enrollment;

import com.exam.colegio.model.person.Student;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollmentStudent")
public class EnrollmentStudent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idEnrollmentStudent;

        @ManyToOne
        @JoinColumn(name = "idStudent", nullable = false)
        private Student student;

        @ManyToOne
        @JoinColumn(name = "idEnrollment", nullable = false)
        private Enrollment enrollment;

}
