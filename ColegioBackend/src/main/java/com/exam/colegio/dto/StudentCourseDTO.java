package com.exam.colegio.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StudentCourseDTO {
        private String dni;
        private String name;
        private String surnamePaternal;
        private String surnameMaternal;
        private String phoneNumber;
        private String grade;
}
