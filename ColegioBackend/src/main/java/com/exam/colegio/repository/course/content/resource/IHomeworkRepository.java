package com.exam.colegio.repository.course.content.resource;

import com.exam.colegio.model.course.content.resource.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeworkRepository extends JpaRepository<Homework, Integer> {
}
