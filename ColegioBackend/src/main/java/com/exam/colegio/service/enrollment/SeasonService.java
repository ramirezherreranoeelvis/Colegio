package com.exam.colegio.service.enrollment;

import com.exam.colegio.dao.enrollment.ISeasonDAO;
import com.exam.colegio.model.enrollment.Season;
import com.exam.colegio.repository.enrollment.ISeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SeasonService implements ISeasonDAO {

        @Override
        public Optional<Season> findById(int id) {
                return this.seasonRepository.findById(id);
        }

        @Autowired
        private ISeasonRepository seasonRepository;

}
