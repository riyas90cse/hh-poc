package com.hh.export.mapper;

import com.hh.export.forms.MDFReportData;
import com.hh.export.model.MDFReport;
import com.hh.export.reftype.YNStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import static com.hh.export.utils.AppUtils.getInstant;

/**
 * Created by Mohamed Riyas
 */
@Component
public class ExportDataMapper {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    public MDFReport map(MDFReportData MDFReportData) {
        LOG.info("Map Export Data to Report Data Entity");
        MDFReport mdfReport = new MDFReport();
        mdfReport.setNoOfAppointments(MDFReportData.getNoOfAppointments());
        mdfReport.setDoctorsNames(MDFReportData.getDoctorsNames());
        mdfReport.setEilgVerIndication(MDFReportData.getEilgVerIndication());
        mdfReport.setPatientName(MDFReportData.getPatientName());
        mdfReport.setPatientDOB(MDFReportData.getPatientDOB());
        mdfReport.setSubscriberName(MDFReportData.getSubscriberName());
        mdfReport.setSubscriberDOB(MDFReportData.getSubscriberDOB());
        mdfReport.setRelationship(MDFReportData.getRelationship());
        mdfReport.setIdNumberAndSSN(MDFReportData.getIdNumberAndSSN());
        mdfReport.setInsuranceName(MDFReportData.getInsuranceName());
        mdfReport.setInsuranceTel(MDFReportData.getInsuranceTel());
        mdfReport.setGroups(MDFReportData.getGroups());
        mdfReport.setPayorIdNumber(MDFReportData.getPayorIdNumber());
        mdfReport.setEmployer(MDFReportData.getEmployer());
        mdfReport.setPlanYear(MDFReportData.getPlanYear());
        mdfReport.setEffectiveDate(MDFReportData.getEffectiveDate());
        mdfReport.setFeeScheduleName(MDFReportData.getFeeScheduleName());
        mdfReport.setIsParticipate(MDFReportData.getIsParticipate());
        mdfReport.setInsrBillAddress(MDFReportData.getInsrBillAddress());
        mdfReport.setInsrRepNameAndCallRef(MDFReportData.getInsrRepNameAndCallRef());
        mdfReport.setAnnualMaximum(MDFReportData.getAnnualMaximum());
        mdfReport.setAnnualMaximumUsed(MDFReportData.getAnnualMaximumUsed());
        mdfReport.setAnnualMaximumLeft(MDFReportData.getAnnualMaximumLeft());
        mdfReport.setIndividualDeductible(MDFReportData.getIndividualDeductible());
        mdfReport.setFamilyDeductible(MDFReportData.getFamilyDeductible());
        mdfReport.setDeductibleApply(MDFReportData.getDeductibleApply());
        mdfReport.setBasicAndMajorPreventive(MDFReportData.getBasicAndMajorPreventive());
        mdfReport.setExamFreqAndHistory(MDFReportData.getExamFreqAndHistory());
        mdfReport.setLoeFreq(MDFReportData.getLoeFreq());
        mdfReport.setChild(MDFReportData.getChild());
        mdfReport.setFlourideAndFreqWithAge(MDFReportData.getFlourideAndFreqWithAge());
        mdfReport.setSealentsAndFreqWithAgeAndHis(MDFReportData.getSealentsAndFreqWithAgeAndHis());
        mdfReport.setBiteWingsAndFreqWithAgeAndHis(MDFReportData.getBiteWingsAndFreqWithAgeAndHis());
        mdfReport.setPanoFmxAndFreqWithAgeAndHis(MDFReportData.getPanoFmxAndFreqWithAgeAndHis());
        mdfReport.setPeriapicalXRayAndFreq(MDFReportData.getPeriapicalXRayAndFreq());
        mdfReport.setPalliativeTxAndFreq(MDFReportData.getPalliativeTxAndFreq());
        mdfReport.setAreCompositeDowngradedIncMolOrPreMol(MDFReportData.getAreCompositeDowngradedIncMolOrPreMol());
        mdfReport.setCoreBuildUpAndFreq(MDFReportData.getCoreBuildUpAndFreq());
        mdfReport.setPreFabricPostAndCore(MDFReportData.getPreFabricPostAndCore());
        mdfReport.setImplants(MDFReportData.getImplants());
        mdfReport.setAreCrownsDowngraded(MDFReportData.getAreCrownsDowngraded());
        mdfReport.setAgeForReplacement(MDFReportData.getAgeForReplacement());
        mdfReport.setPaidOnPrepOrSeatDate(MDFReportData.getPaidOnPrepOrSeatDate());
        mdfReport.setWaitingPeriod(MDFReportData.getWaitingPeriod());
        mdfReport.setMissingToothClause(MDFReportData.getMissingToothClause());
        mdfReport.setEndodontics(MDFReportData.getEndodontics());
        mdfReport.setSrpAndFreqWithQuadPerDay(MDFReportData.getSrpAndFreqWithQuadPerDay());
        mdfReport.setFmdFreq(MDFReportData.getFmdFreq());
        mdfReport.setGingivitisAndFreq(MDFReportData.getGingivitisAndFreq());
        mdfReport.setPerioMaintanenceAndFreqWithShare(MDFReportData.getPerioMaintanenceAndFreqWithShare());
        mdfReport.setArestinAndFreq(MDFReportData.getArestinAndFreq());
        mdfReport.setTmjAndFreq(MDFReportData.getTmjAndFreq());
        mdfReport.setOralSurgeryAndFreq(MDFReportData.getOralSurgeryAndFreq());
        mdfReport.setOcclusionGuardsAndFreq(MDFReportData.getOcclusionGuardsAndFreq());
        mdfReport.setOrthodontics(MDFReportData.getOrthodontics());
        mdfReport.setOrthoLifetimeMaxAndAgeLimit(MDFReportData.getOrthoLifetimeMaxAndAgeLimit());
        mdfReport.setOrthoDeductible(MDFReportData.getOrthoDeductible());
        mdfReport.setOrthoPaymentMade(MDFReportData.getOrthoPaymentMade());
        mdfReport.setCreatedBy("System");
        mdfReport.setCreatedDate(getInstant());
        mdfReport.setUpdatedBy("System");
        mdfReport.setUpdatedDate(getInstant());
        mdfReport.setDeleted(YNStatus.NO.getStatus());
        return mdfReport;
    }

}
