package com.exam.colegio.service;

import com.exam.colegio.dao.IStudentDAO;
import com.exam.colegio.entity.person.Student;
import com.exam.colegio.repository.person.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService implements IStudentDAO {

        @Override
        public Student findByUsername(String username) {
                return null;
        }

        @Override
        public Student findByDni(Integer dni) {
                return null;
        }

        @Autowired
        private IStudentRepository studentRepository;

}
