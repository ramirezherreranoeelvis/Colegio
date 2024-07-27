package com.exam.colegio.mvc.entity.entity.course;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "course")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idCourse;

        @Column(name = "name", nullable = false, length = 50, unique = true)
        private String name;

}
