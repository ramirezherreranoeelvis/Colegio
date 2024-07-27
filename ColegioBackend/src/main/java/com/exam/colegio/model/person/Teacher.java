package com.exam.colegio.mvc.entity.entity.person;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("teacher")
public class Teacher extends Person {

        @Builder
        public Teacher(Integer idPerson, String dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

        @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<com.exam.colegio.mvc.entity.entity.other.TeacherCourseScheduled> TeacherCourseScheduled = new ArrayList<>();

}
