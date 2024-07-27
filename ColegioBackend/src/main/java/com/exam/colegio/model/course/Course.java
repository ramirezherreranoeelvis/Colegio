package com.exam.colegio.model.course;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idCourse;

        @Column(name = "name", nullable = false, length = 50, unique = true)
        private String name;

}
