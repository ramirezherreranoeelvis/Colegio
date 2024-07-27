package com.exam.colegio.repository.enrollment;

import com.exam.colegio.model.enrollment.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Integer> {

}
