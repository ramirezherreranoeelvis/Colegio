package com.exam.colegio.model;

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
}
