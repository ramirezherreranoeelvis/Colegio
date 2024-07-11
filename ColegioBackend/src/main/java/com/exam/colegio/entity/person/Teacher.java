package com.exam.colegio.entity.person;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("teacher")
public class Teacher extends Person {

        @Builder
        public Teacher(Integer idPerson, Integer dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

}
