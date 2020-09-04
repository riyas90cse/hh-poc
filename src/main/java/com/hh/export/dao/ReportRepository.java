package com.hh.export.dao;

import com.hh.export.model.MDFReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<MDFReport, Long> {

    List<MDFReport> findByDeleted(String deleted);

}
