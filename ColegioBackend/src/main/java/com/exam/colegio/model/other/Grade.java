package com.exam.colegio.mvc.entity.entity.other;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grade")
public class Grade {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idGrade;

        @Column(name = "name", nullable = false, unique = true, length = 30)
        private String name;

}
