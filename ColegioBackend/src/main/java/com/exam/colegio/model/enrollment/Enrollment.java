package com.exam.colegio.mvc.entity.entity.enrollment;

import com.exam.colegio.mvc.entity.entity.other.Grade;
import com.exam.colegio.mvc.entity.entity.course.CourseScheduled;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollment")
public class Enrollment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idEnrollment;

        @ManyToOne
        @JoinColumn(name = "idSeason", nullable = false)
        private Season season;

        @ManyToOne
        @JoinColumn(name = "idGrade", nullable = false)
        private Grade grade;

        @Column(name = "vacancies", nullable = false)
        private Integer vacancies;

        @Column(name = "enrolled", nullable = false)
        private Integer enrolled;

        @Column(name = "cost", nullable = false, precision = 6, scale = 2)
        private BigDecimal cost;

        @Column(name = "monthlyFee", nullable = false, precision = 6, scale = 2)
        private BigDecimal monthlyFee;

        @JsonIgnore
        @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
        private final List<EnrollmentStudent> enrollmentStudents = new ArrayList<>();

        @JsonIgnore
        @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
        private final List<CourseScheduled> courseScheduleds = new ArrayList<>();

}
