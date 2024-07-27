package com.exam.colegio.repository.other;

import com.exam.colegio.model.other.EntrySchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrySchoolRepository extends JpaRepository<EntrySchool, Integer> {

}
