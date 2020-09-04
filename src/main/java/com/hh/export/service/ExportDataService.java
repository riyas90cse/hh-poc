package com.hh.export.service;

import com.hh.export.exception.HHExportException;
import com.hh.export.model.MDFReport;

import java.util.List;

/**
 * Created by Mohamed Riyas
 */
public interface ExportDataService {

    MDFReport addReportData(final MDFReport MDFReport);

    List<MDFReport> reportDataList();

    MDFReport findReportData(Long id) throws HHExportException;

}
