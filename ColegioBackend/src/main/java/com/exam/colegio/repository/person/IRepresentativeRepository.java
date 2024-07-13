package com.exam.colegio.repository.person;

import com.exam.colegio.entity.person.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepresentativeRepository extends JpaRepository<Representative, Integer> {

}
