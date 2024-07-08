package com.exam.colegio.entity.course;

import com.exam.colegio.entity.Classroom;
import com.exam.colegio.entity.enrollment.Enrollment;
import com.exam.colegio.entity.person.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@Entity
@Table(name = "gradeCourseScheduled")
public class GradeCourseScheduled {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idGradeCourseScheduled;

        @ManyToOne
        @JoinColumn(name = "idGradeType", nullable = false)
        private GradeType gradeType;

        @ManyToOne
        @JoinColumn(name = "idCourseScheduled", nullable = false)
        private CourseScheduled courseScheduled;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false)
        private Student student;

        @Column(name = "grade", precision = 4, scale = 2)
        private BigDecimal grade;


}
