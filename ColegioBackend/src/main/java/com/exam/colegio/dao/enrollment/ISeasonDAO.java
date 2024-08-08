package com.exam.colegio.dao.enrollment;

import com.exam.colegio.model.enrollment.Season;

import java.util.Optional;
public interface ISeasonDAO {

        Optional<Season> findById(int id);

}
