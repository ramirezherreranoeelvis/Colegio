package com.exam.colegio.model.course.session;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "session")
public class Session {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idSession;

        @Column(name = "name", nullable = true, length = 150)
        private String name;

        @Column(name = "number", nullable = false)
        private int number;

        @Column(name = "isVisible", nullable = false)
        private boolean isVisible;

}
