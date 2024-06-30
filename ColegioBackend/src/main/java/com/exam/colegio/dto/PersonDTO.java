package com.exam.colegio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PersonDTO {

        private String dni;
        private String name;
        private String surnameMaternal;
        private String surnamePaternal;
        private int phoneNumber;

}
