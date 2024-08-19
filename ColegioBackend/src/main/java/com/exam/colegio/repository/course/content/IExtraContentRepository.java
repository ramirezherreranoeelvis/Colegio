package com.exam.colegio.repository.course.content;

import com.exam.colegio.model.course.content.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gatomontes
 */
@Repository
public interface IExtraRepository extends JpaRepository<Session, Integer> {

}
