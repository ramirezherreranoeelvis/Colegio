package com.exam.colegio.dao.other;

import com.exam.colegio.model.other.EntrySchool;

import java.util.List;
public interface IEntrySchoolDAO {

        String findByStudent(String dniStudent);

        List<EntrySchool> findAll();

}
