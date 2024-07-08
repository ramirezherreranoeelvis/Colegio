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
@Table(name = "payment")
public class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idPayment;

        @ManyToOne
        @JoinColumn(name = "idEnrollmentStudent", nullable = false)
        private EnrollmentStudent enrollmentStudent;

        @ManyToOne
        @JoinColumn(name = "idTypeStatus", nullable = false)
        private TypeStatus typeStatus;

        @Column(name = "pay", precision = 6, scale = 2)
        private BigDecimal pay;

        @Column(name = "description", length = 50)
        private String description;

}
