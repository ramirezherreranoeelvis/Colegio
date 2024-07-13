package com.exam.colegio.repository.person;

import com.exam.colegio.entity.person.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFatherRepository extends JpaRepository<Father, Integer> {

}
