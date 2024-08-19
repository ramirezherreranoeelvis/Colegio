package com.exam.colegio.model.course.session.content;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "content")
public class Content {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idContent;

        @Column(name = "name", nullable = true, length = 150)
        private String name;

        @Column(name = "number", nullable = false)
        private int number;

        @Column(name = "isVisible", nullable = false)
        private boolean isVisible;


}
