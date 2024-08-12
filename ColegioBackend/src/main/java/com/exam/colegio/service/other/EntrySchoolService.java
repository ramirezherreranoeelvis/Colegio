package com.exam.colegio.service.other;

import com.exam.colegio.dao.other.IEntrySchoolDAO;
import com.exam.colegio.model.other.EntrySchool;
import com.exam.colegio.repository.other.IEntrySchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrySchoolService implements IEntrySchoolDAO {

        @Override
        public String findByStudent(String dniStudent) {
                return "";
        }

        @Override
        public List<EntrySchool> findAll() {
                return entrySchoolRepository.findAll();
        }

        private final IEntrySchoolRepository entrySchoolRepository;

        @Autowired
        public EntrySchoolService(IEntrySchoolRepository entrySchoolRepository) {
                this.entrySchoolRepository = entrySchoolRepository;
        }

}
