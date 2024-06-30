package com.exam.colegio.model;

import com.exam.colegio.annotation.Dni;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idPerson;

        @Dni
        @Column(name = "dni", nullable = false, unique = true, updatable = false)
        private int dni;

        @Column(name = "name", length = 200, nullable = false, unique = false)
        private String name;

        @Column(name = "surnameMaternal", length = 150, nullable = false, unique = false)
        private String surnameMaternal;

        @Column(name = "surnamePaternal", length = 150, nullable = false, unique = false)
        private String surnamePaternal;

        @Column(name = "phoneNumber", nullable = false)
        private int phoneNumber;

}
