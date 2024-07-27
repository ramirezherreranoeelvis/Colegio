package com.exam.colegio.mvc.entity.entity.person;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("father")
public class Father extends Person {

        @Builder
        public Father(Integer idPerson, String dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

}