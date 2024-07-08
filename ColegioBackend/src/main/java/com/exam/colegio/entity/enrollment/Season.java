package com.exam.colegio.entity.registration;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@Table(name = "season")
public class Season {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idSeason;

        @Column(name = "year", nullable = false, updatable = false, unique = true)
        private Date year;


}
