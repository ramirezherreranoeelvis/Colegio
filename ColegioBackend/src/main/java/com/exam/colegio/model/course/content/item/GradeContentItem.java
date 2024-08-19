package com.exam.colegio.model.course.content.item;

import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.course.GradeType;
import com.exam.colegio.model.person.Student;
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
        private int idGradeCourseScheduled;

        @ManyToOne
        @JoinColumn(name = "idGradeType", nullable = false)
        private GradeType gradeType;

        @ManyToOne
        @JoinColumn(name = "idCourseScheduled", nullable = false)
        private CourseScheduled courseScheduled;

        @ManyToOne
        @JoinColumn(name = "idStudent", nullable = false)
        private Student student;

        @Column(name = "grade", precision = 4, scale = 2, nullable = false)
        private BigDecimal grade;


}
