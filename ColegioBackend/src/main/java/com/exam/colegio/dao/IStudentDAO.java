package com.exam.colegio.dao;

import com.exam.colegio.entity.person.Student;
public interface IStudentDAO {

        Student findByUsername(String username);

        Student findByDni(Integer dni);

}
