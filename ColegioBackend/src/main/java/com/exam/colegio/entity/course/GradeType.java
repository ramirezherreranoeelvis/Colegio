package com.exam.colegio.entity.course;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "gradeType")
public class GradeType {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idGradeType;

        @Column(name = "name", nullable = false, length = 20)
        private String name;

}
