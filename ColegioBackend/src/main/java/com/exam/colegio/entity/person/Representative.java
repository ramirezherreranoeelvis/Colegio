package com.exam.colegio.entity.person;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("representative")
public class Representative extends Person {

        @Builder
        public Representative(Integer idPerson, Integer dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

}
