package com.exam.colegio.dao;

import com.exam.colegio.model.person.Student;

import java.util.Optional;

public interface IStudentDAO {

        Optional<Student> findByUsername(String username);

        Optional<Student> findByDni(String dni);

}
