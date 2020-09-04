package com.hh.export.controller;

import com.hh.export.exception.HHExportException;
import com.hh.export.forms.MDFExportForm;
import com.hh.export.forms.MDFReportData;
import com.hh.export.mapper.ExportDataMapper;
import com.hh.export.service.ExportDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ExportController {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    private static final String LANDING_PAGE = "landing/landing";
    private static final String EXPORT_PAGE = "list/export";
    private static final String LIST_PAGE = "list/list";
    private final ExportDataService exportDataService;
    private final ExportDataMapper exportDataMapper;

    public ExportController(
            @Autowired ExportDataService exportDataService,
            @Autowired ExportDataMapper exportDataMapper) {
        this.exportDataService = exportDataService;
        this.exportDataMapper = exportDataMapper;
    }

    @GetMapping(value = {"/", "/index.html"})
    public String landingPage(ModelMap model) throws HHExportException {
        LOG.info("Open Landing page");
        return LANDING_PAGE;
    }

    @GetMapping(value = {"/export.html"})
    public String export(ModelMap model) throws HHExportException {
        LOG.info("Open Export page");
        model.addAttribute("exportForm", new MDFExportForm());
        return EXPORT_PAGE;
    }

    @PostMapping(value = "/export.html")
    public String addNewUser(@ModelAttribute("exportForm") MDFExportForm mdfExportForm) throws HHExportException {
        LOG.info("Export File on submit");
        MDFReportData mdfReportData = readExcelFile(mdfExportForm.getExportFile());
        LOG.debug("Exported Details {}", mdfReportData);
        exportDataService.addReportData(exportDataMapper.map(mdfReportData));
        return "redirect:/list.html";
    }

    private MDFReportData readExcelFile(MultipartFile exportFile) throws HHExportException {
        MDFReportData mdfReportData = new MDFReportData();
        if (!exportFile.isEmpty()) {
            try (Workbook workbook = WorkbookFactory.create(exportFile.getInputStream())) {
                Sheet sheet = workbook.getSheetAt(0);
                mdfReportData = writeMDFReportFromSheet(sheet);
            } catch (IOException | InvalidFormatException e) {
                throw new HHExportException("IO Exception occurred while viewing gallery image " + e.getMessage());
            }
        }
        return mdfReportData;
    }

    @GetMapping(value = "/list.html")
    public String listExportData(ModelMap model) {
        LOG.info("Open Export List page");
        model.addAttribute("exportedList", exportDataService.reportDataList());
        return LIST_PAGE;
    }

    private MDFReportData writeMDFReportFromSheet(Sheet sheet) {
        MDFReportData mdfReportData = new MDFReportData();
        DataFormatter dataFormatter = new DataFormatter();
        mdfReportData.setNoOfAppointments(dataFormatter.formatCellValue(sheet.getRow(0).getCell(1)));
        mdfReportData.setDoctorsNames(dataFormatter.formatCellValue((sheet.getRow(1).getCell(1))));
        mdfReportData.setEilgVerIndication(dataFormatter.formatCellValue((sheet.getRow(3).getCell(1))));
        mdfReportData.setPatientName(dataFormatter.formatCellValue((sheet.getRow(4).getCell(1))));
        mdfReportData.setPatientDOB(dataFormatter.formatCellValue(sheet.getRow(5).getCell(1)));
        mdfReportData.setSubscriberName(dataFormatter.formatCellValue(sheet.getRow(6).getCell(1)));
        mdfReportData.setSubscriberDOB(dataFormatter.formatCellValue(sheet.getRow(7).getCell(1)));
        mdfReportData.setRelationship(dataFormatter.formatCellValue(sheet.getRow(8).getCell(1)));
        mdfReportData.setIdNumberAndSSN(dataFormatter.formatCellValue(sheet.getRow(9).getCell(1)));
        mdfReportData.setInsuranceName(dataFormatter.formatCellValue(sheet.getRow(10).getCell(1)));
        mdfReportData.setInsuranceTel(dataFormatter.formatCellValue(sheet.getRow(11).getCell(1)));
        mdfReportData.setGroups(dataFormatter.formatCellValue(sheet.getRow(12).getCell(1)));
        mdfReportData.setPayorIdNumber(dataFormatter.formatCellValue(sheet.getRow(13).getCell(1)));
        mdfReportData.setEmployer(dataFormatter.formatCellValue(sheet.getRow(14).getCell(1)));
        mdfReportData.setPlanYear(dataFormatter.formatCellValue(sheet.getRow(15).getCell(1)));
        mdfReportData.setEffectiveDate(dataFormatter.formatCellValue(sheet.getRow(16).getCell(1)));
        mdfReportData.setFeeScheduleName(dataFormatter.formatCellValue(sheet.getRow(17).getCell(1)));
        mdfReportData.setIsParticipate(dataFormatter.formatCellValue(sheet.getRow(18).getCell(1)));
        mdfReportData.setInsrBillAddress(dataFormatter.formatCellValue(sheet.getRow(19).getCell(1)));
        mdfReportData.setInsrRepNameAndCallRef(dataFormatter.formatCellValue(sheet.getRow(20).getCell(1)));
        mdfReportData.setAnnualMaximum(dataFormatter.formatCellValue(sheet.getRow(21).getCell(1)));
        mdfReportData.setAnnualMaximumUsed(dataFormatter.formatCellValue(sheet.getRow(22).getCell(1)));
        mdfReportData.setAnnualMaximumLeft(dataFormatter.formatCellValue(sheet.getRow(23).getCell(1)));
        mdfReportData.setIndividualDeductible(dataFormatter.formatCellValue(sheet.getRow(24).getCell(1)));
        mdfReportData.setFamilyDeductible(dataFormatter.formatCellValue(sheet.getRow(25).getCell(1)));
        mdfReportData.setDeductibleApply(dataFormatter.formatCellValue(sheet.getRow(26).getCell(1)));
        mdfReportData.setBasicAndMajorPreventive(dataFormatter.formatCellValue(sheet.getRow(27).getCell(1)));
        mdfReportData.setExamFreqAndHistory(dataFormatter.formatCellValue(sheet.getRow(28).getCell(1)));
        mdfReportData.setLoeFreq(dataFormatter.formatCellValue(sheet.getRow(29).getCell(1)));
        mdfReportData.setChild(dataFormatter.formatCellValue(sheet.getRow(30).getCell(1)));
        mdfReportData.setFlourideAndFreqWithAge(dataFormatter.formatCellValue(sheet.getRow(31).getCell(1)));
        mdfReportData.setSealentsAndFreqWithAgeAndHis(dataFormatter.formatCellValue(sheet.getRow(32).getCell(1)));
        mdfReportData.setBiteWingsAndFreqWithAgeAndHis(dataFormatter.formatCellValue(sheet.getRow(33).getCell(1)));
        mdfReportData.setPanoFmxAndFreqWithAgeAndHis(dataFormatter.formatCellValue(sheet.getRow(34).getCell(1)));
        mdfReportData.setPeriapicalXRayAndFreq(dataFormatter.formatCellValue(sheet.getRow(35).getCell(1)));
        mdfReportData.setPalliativeTxAndFreq(dataFormatter.formatCellValue(sheet.getRow(36).getCell(1)));
        mdfReportData.setAreCompositeDowngradedIncMolOrPreMol(dataFormatter.formatCellValue(sheet.getRow(37).getCell(1)));
        mdfReportData.setCoreBuildUpAndFreq(dataFormatter.formatCellValue(sheet.getRow(38).getCell(1)));
        mdfReportData.setPreFabricPostAndCore(dataFormatter.formatCellValue(sheet.getRow(39).getCell(1)));
        mdfReportData.setImplants(dataFormatter.formatCellValue(sheet.getRow(40).getCell(1)));
        mdfReportData.setAreCrownsDowngraded(dataFormatter.formatCellValue(sheet.getRow(41).getCell(1)));
        mdfReportData.setAgeForReplacement(dataFormatter.formatCellValue(sheet.getRow(42).getCell(1)));
        mdfReportData.setPaidOnPrepOrSeatDate(dataFormatter.formatCellValue(sheet.getRow(43).getCell(1)));
        mdfReportData.setWaitingPeriod(dataFormatter.formatCellValue(sheet.getRow(44).getCell(1)));
        mdfReportData.setMissingToothClause(dataFormatter.formatCellValue(sheet.getRow(45).getCell(1)));
        mdfReportData.setEndodontics(dataFormatter.formatCellValue(sheet.getRow(46).getCell(1)));
        mdfReportData.setSrpAndFreqWithQuadPerDay(dataFormatter.formatCellValue(sheet.getRow(47).getCell(1)));
        mdfReportData.setFmdFreq(dataFormatter.formatCellValue(sheet.getRow(48).getCell(1)));
        mdfReportData.setGingivitisAndFreq(dataFormatter.formatCellValue(sheet.getRow(49).getCell(1)));
        mdfReportData.setPerioMaintanenceAndFreqWithShare(dataFormatter.formatCellValue(sheet.getRow(50).getCell(1)));
        mdfReportData.setArestinAndFreq(dataFormatter.formatCellValue(sheet.getRow(51).getCell(1)));
        mdfReportData.setTmjAndFreq(dataFormatter.formatCellValue(sheet.getRow(52).getCell(1)));
        mdfReportData.setOralSurgeryAndFreq(dataFormatter.formatCellValue(sheet.getRow(53).getCell(1)));
        mdfReportData.setOcclusionGuardsAndFreq(dataFormatter.formatCellValue(sheet.getRow(54).getCell(1)));
        mdfReportData.setOrthodontics(dataFormatter.formatCellValue(sheet.getRow(55).getCell(1)));
        mdfReportData.setOrthoLifetimeMaxAndAgeLimit(dataFormatter.formatCellValue(sheet.getRow(56).getCell(1)));
        mdfReportData.setOrthoDeductible(dataFormatter.formatCellValue(sheet.getRow(57).getCell(1)));
        mdfReportData.setOrthoPaymentMade(dataFormatter.formatCellValue(sheet.getRow(58).getCell(1)));
        return mdfReportData;
    }

}
