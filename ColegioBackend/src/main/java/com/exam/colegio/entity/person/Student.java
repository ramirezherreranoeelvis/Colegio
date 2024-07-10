package com.exam.colegio.entity.person;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("student")
public class Student extends Person {

        @ManyToOne
        @JoinColumn(name = "idFather", nullable = false, updatable = false)
        private Father father;

        @ManyToOne
        @JoinColumn(name = "idMother", nullable = false, updatable = false)
        private Mother mother;

        @ManyToOne
        @JoinColumn(name = "idRepresentative", nullable = false)
        private Representative representative;

        @Builder
        public Student(Integer idPerson, Integer dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

}
