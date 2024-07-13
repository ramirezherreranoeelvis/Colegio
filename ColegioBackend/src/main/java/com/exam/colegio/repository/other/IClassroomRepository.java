package com.exam.colegio.repository.other;

import com.exam.colegio.entity.other.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {

}
