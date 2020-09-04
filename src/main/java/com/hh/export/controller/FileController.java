package com.hh.export.controller;

import com.hh.export.exception.HHExportException;
import com.hh.export.model.MDFReport;
import com.hh.export.service.ExportDataService;
import com.hh.export.service.writer.HHExportPDFBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mohamed Riyas
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private final Logger LOG = LogManager.getLogger(this.getClass());
    private final ExportDataService exportDataService;
    private final HHExportPDFBuilder hhExportPDFBuilder;

    public FileController(
            @Autowired ExportDataService exportDataService,
            @Autowired HHExportPDFBuilder hhExportPDFBuilder
            ) {
        this.exportDataService = exportDataService;
        this.hhExportPDFBuilder = hhExportPDFBuilder;
    }

    @GetMapping(value = "/prepare/{id}/pdf.html")
    public void preparePDF(HttpServletResponse response, @PathVariable Long id) throws HHExportException {
        LOG.info("Preparing PDF for Report Data");
        try {
            MDFReport reportData = exportDataService.findReportData(id);
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%d_%s\"", id, "report_data.pdf"));
            response.setCharacterEncoding("UTF-8");
            hhExportPDFBuilder.initialize(reportData, response.getOutputStream()).buildPDFWithFormContent();
            response.flushBuffer();
        } catch (IOException t) {
            LOG.warn("Exception occurred at parsing pdf {}", t.getMessage());
            throw new HHExportException("Exception occurred at parsing pdf");
        }
    }

}