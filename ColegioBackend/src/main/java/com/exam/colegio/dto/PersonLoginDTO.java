package com.exam.colegio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PersonLoginDTO {

        private Integer dni;
        private String name;
        private String surnamePaternal;
        private String surnameMaternal;
        private int phoneNumber;
        private String username;
        private String password;

}
