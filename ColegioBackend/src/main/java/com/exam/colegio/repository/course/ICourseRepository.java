package com.exam.colegio.repository.person;

import com.exam.colegio.entity.person.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
