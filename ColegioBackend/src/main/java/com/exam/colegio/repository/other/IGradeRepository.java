package com.exam.colegio.repository.other;

import com.exam.colegio.entity.other.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Integer> {

}
