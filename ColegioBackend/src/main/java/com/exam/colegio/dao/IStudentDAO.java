package com.exam.colegio.dao;

import com.exam.colegio.entity.person.Student;

import java.util.Optional;
public interface IStudentDAO {

        Optional<Student> findByUsername(String username);

}
