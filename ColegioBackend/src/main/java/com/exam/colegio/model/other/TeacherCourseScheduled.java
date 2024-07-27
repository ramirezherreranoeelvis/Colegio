package com.exam.colegio.mvc.entity.entity.other;

import com.exam.colegio.mvc.entity.entity.course.CourseScheduled;
import com.exam.colegio.mvc.entity.entity.person.Teacher;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@Entity
@Table(name = "teacherCourseScheduled")
public class TeacherCourseScheduled {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idTeacherCourseScheduled;

        @ManyToOne
        @JoinColumn(name = "idTeacher", nullable = false)
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "idCourseScheduled", nullable = false)
        private CourseScheduled courseScheduled;

        @Column(name = "salary", nullable = false, precision = 6, scale = 2)
        private BigDecimal salary;

}
