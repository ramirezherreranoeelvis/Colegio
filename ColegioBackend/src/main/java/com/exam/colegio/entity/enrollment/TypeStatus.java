package com.exam.colegio.entity.registration;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
@Table(name = "typeStatus")
public class TypeStatus {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idTypeStatus;

        @Column(name = "name", nullable = false, length = 20, unique = true)
        private String name;

}
