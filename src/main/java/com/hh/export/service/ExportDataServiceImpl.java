package com.hh.export.service;

import com.hh.export.dao.ReportRepository;
import com.hh.export.exception.HHExportException;
import com.hh.export.model.MDFReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

/**
 * Created by Mohamed Riyas
 */

@Service
@Transactional
public class ExportDataServiceImpl implements ExportDataService {

    private final Logger LOG = LogManager.getLogger(this.getClass());
    private final ReportRepository reportRepository;

    public ExportDataServiceImpl(@Autowired ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public MDFReport addReportData(final MDFReport MDFReport) {
        LOG.info("Add New Report Data in the database");
        MDFReport savedMDFReport = reportRepository.save(MDFReport);
        LOG.info("Saved New Report Data in the database");
        return savedMDFReport;
    }

    @Override
    public List<MDFReport> reportDataList() {
        LOG.info("Get all ReportData from the database");
        return reportRepository.findAll();
    }

    @Override
    public MDFReport findReportData(Long id) throws HHExportException {
        Optional<MDFReport> reportDataOptional = reportRepository.findById(id);
        if (reportDataOptional.isPresent()) {
            return reportDataOptional.get();
        }
        throw new HHExportException(format("ReportData is not found with the id %d", id));
    }
}
