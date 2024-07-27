package com.exam.colegio.mvc.entity.entity.person;

import com.exam.colegio.mvc.entity.entity.enrollment.EnrollmentStudent;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("student")
public class Student extends Person {

        @ManyToOne
        @JoinColumn(name = "idFather")
        private Father father;

        @ManyToOne
        @JoinColumn(name = "idMother")
        private Mother mother;

        @ManyToOne
        @JoinColumn(name = "idRepresentative")
        private Representative representative;

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<EnrollmentStudent> enrollmentStudents = new ArrayList<>();

        @Builder
        public Student(Integer idPerson, String dni, String name, String surnamePaternal, String surnameMaternal, int phoneNumber, Access access) {
                super(idPerson, dni, name, surnamePaternal, surnameMaternal, phoneNumber, access);
        }

}
