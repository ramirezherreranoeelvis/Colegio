package com.exam.colegio.repository.person;

import com.exam.colegio.entity.person.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, Integer> {

}
