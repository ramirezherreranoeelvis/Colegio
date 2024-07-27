package com.exam.colegio.mvc.entity.entity.other;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "classroom")
public class Classroom {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idClassroom;

        @Column(name = "number", nullable = false, unique = true)
        private int number;

        @Column(name = "floor", nullable = false)
        private int floor;

}
