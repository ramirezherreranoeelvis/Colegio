package com.exam.colegio.service;

import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.model.person.Student;
import com.exam.colegio.repository.person.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Gatomontes
 */
@Service
public class StudentService implements IStudentDAO {

        @Override
        public Optional<Student> findByUsername(String username) {
                return studentRepository.findByAccessUsername(username);
        }

        @Override
        public Optional<Student> findByDni(String dni) {
                return studentRepository.findByDni(dni);
        }

        @Autowired
        private IStudentRepository studentRepository;



}
