package com.exam.colegio.model.entity;

import com.exam.colegio.annotation.Dni;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@DiscriminatorColumn(name = "typePerson", discriminatorType = DiscriminatorType.STRING, length = 20)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "person")
public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idPerson;

        @Dni
        @Column(name = "dni", nullable = false, unique = true, updatable = false)
        private Integer dni;

        @Column(name = "name", nullable = false, length = 250)
        private String name;

        @Column(name = "surnamePaternal", nullable = false, length = 50)
        private String surnamePaternal;

        @Column(name = "surnameMaternal", nullable = false, length = 50)
        private String surnameMaternal;

        @Column(name = "phoneNumber", nullable = false)
        private int phoneNumber;

        @ManyToOne
        @JoinColumn(name = "idAccess", nullable = false, unique = true, updatable = false)
        private Access access;



}
