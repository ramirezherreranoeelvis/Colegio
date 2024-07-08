package com.exam.colegio.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "access")
public class Access {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idAccess;

        @Column(name = "access", nullable = false)
        private boolean accessEnabled;

        @Column(name = "username", nullable = false, unique = true, updatable = false, length = 20)
        private String username;

        @Column(name = "description", length = 150)
        private String description;

        @Column(name = "password", nullable = false, length = 20)
        private String password;


}
