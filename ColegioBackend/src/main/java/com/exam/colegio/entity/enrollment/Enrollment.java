package com.exam.colegio.entity.enrollment;


import com.exam.colegio.entity.Grade;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@Entity
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


}
