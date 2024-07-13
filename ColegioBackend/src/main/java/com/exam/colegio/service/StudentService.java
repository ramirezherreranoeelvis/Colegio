package com.exam.colegio.service;

import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.entity.person.Student;
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
                var student = studentRepository.findByAccessUsername(username);

                return student;
        }

        @Autowired
        private IStudentRepository studentRepository;

}
