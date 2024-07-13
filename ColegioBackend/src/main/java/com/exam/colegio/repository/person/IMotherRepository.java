package com.exam.colegio.repository.person;

import com.exam.colegio.entity.person.Mother;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotherRepository extends JpaRepository<Mother, Integer> {

}
