package com.exam.colegio.model.course;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "resource")
public class Resource {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idResource;

        @ManyToOne
        @JoinColumn(name = "idSession", nullable = false)
        private Session session;

        @Column(name = "name", nullable = false, length = 100)
        private String name;

}
