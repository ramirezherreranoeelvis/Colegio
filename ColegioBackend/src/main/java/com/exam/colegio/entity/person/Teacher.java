package com.exam.colegio.entity.person;

import com.exam.colegio.entity.enrollment.EnrollmentStudent;
import com.exam.colegio.entity.other.TeacherCourseScheduled;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

        @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<TeacherCourseScheduled> TeacherCourseScheduled = new ArrayList<>();

}
