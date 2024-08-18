package com.exam.colegio.model.course;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

        @Column(name = "timeEntry", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeEntry;

        @Column(name = "timeExit")
        @Temporal(TemporalType.TIMESTAMP)
        private Date timeExit;

        @Column(name = "isVisible", nullable = false)
        private boolean isVisible;

}
