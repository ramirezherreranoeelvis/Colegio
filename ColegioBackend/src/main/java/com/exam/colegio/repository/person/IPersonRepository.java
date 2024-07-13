package com.exam.colegio.repository;

import com.exam.colegio.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

        Optional<Person> findByAccessUsernameAndAccessPassword(String username, String password);

}
