package com.exam.colegio.repository.report;

import com.exam.colegio.model.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<Report, Integer> {

}
