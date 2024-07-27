package com.exam.colegio.model.other;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
