package com.exam.colegio.dao.report;

import com.exam.colegio.model.report.Report;

import java.util.List;
public interface ReportDAO {

        List<Report> findAllByStudent(String dni);

}
