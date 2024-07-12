package com.exam.colegio.entity.other;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "grade")
public class Grade {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idGrade;

        @Column(name = "name", nullable = false, unique = true, length = 30)
        private String name;

}
