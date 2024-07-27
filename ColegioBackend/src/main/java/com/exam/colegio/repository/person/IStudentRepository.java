package com.exam.colegio.repository.person;

import com.exam.colegio.model.person.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Gatomontes
 */
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

        Optional<Student> findByAccessUsername(String username);
        Optional<Student> findByDni(String dni);

}
