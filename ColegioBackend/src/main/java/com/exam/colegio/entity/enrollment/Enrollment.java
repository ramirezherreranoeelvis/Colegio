package com.exam.colegio.entity.registration;


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
        @JoinColumn(name = "season", nullable = false)
        private Season season;

        @Column(name = "vacancies", nullable = false)
        private Integer vacancies;

        @Column(name = "enrolled", nullable = false)
        private Integer enrolled;

        @Column(name = "cost", nullable = false, precision = 6, scale = 2)
        private BigDecimal cost;

        @Column(name = "monthlyFee", nullable = false, precision = 6, scale = 2)
        private BigDecimal monthlyFee;


}
