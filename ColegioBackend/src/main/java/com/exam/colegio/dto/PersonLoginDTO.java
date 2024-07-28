package com.exam.colegio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
public class PersonLoginDTO implements Serializable {

        private String dni;
        private String name;
        private String surnamePaternal;
        private String surnameMaternal;
        private String phoneNumber;
        private boolean accessEnabled;
        private String username;
        private String password;
        private String description;
        private String typePerson;

}
