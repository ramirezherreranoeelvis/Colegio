package com.exam.colegio.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "reportPerson")
public class ReportPerson {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idReportPerson;

        @ManyToOne
        @JoinColumn(name = "idPerson", nullable = false)
        private Person person;

        @ManyToOne
        @JoinColumn(name = "idReport", nullable = false)
        private Report report;

}
