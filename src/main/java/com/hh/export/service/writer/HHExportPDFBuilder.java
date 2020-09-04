package com.hh.export.service.writer;

import com.hh.export.exception.HHExportException;
import com.hh.export.model.MDFReport;

import java.io.OutputStream;

/**
 * Interface to build the pdf content for the enrollment form
 *
 * @author Mohamed Riyas
 */
public interface HHExportPDFBuilder {

    HHExportPDFBuilder initialize(MDFReport report, OutputStream os);

    void buildPDFWithFormContent() throws HHExportException;

    HHExportPDFBuilder createPdfPage();

    HHExportPDFBuilder createContentStream() throws HHExportException;

    void cleanupResources() throws HHExportException;

    void persistPdfOnStream() throws HHExportException;

    HHExportPDFBuilder createFieldMemberAndDate() throws HHExportException;

    HHExportPDFBuilder createSSIDAndEffecDate() throws HHExportException;

    HHExportPDFBuilder createDOBAndSpokeTo() throws HHExportException;

    HHExportPDFBuilder createPTDOBAndBy() throws HHExportException;

    HHExportPDFBuilder createInsrCoFeeScheAndGroup() throws HHExportException;

    HHExportPDFBuilder createPhoneAndEmployer() throws HHExportException;

    HHExportPDFBuilder createAddressAndHistory() throws HHExportException;

    HHExportPDFBuilder createYearlyMaxAndProphy() throws HHExportException;

    HHExportPDFBuilder createUsedBenefitsAndExams() throws HHExportException;

    HHExportPDFBuilder createDedAndMedAndFreq() throws HHExportException;

    HHExportPDFBuilder createDedAppAndBwx() throws HHExportException;

    HHExportPDFBuilder createPrevAndPano() throws HHExportException;

    HHExportPDFBuilder createFieldsBasicFluorideFreqAge() throws HHExportException;

    HHExportPDFBuilder createFieldsMajorSealentsFreqAge() throws HHExportException;

    HHExportPDFBuilder createCoreBuildUpAndAgeForReplace() throws HHExportException;

    HHExportPDFBuilder createPrefabAndPaidAtSeat() throws HHExportException;

    HHExportPDFBuilder createEndoAndMissingToothClause() throws HHExportException;

    HHExportPDFBuilder createFieldsSrpFreqMolarOrPre() throws HHExportException;

    HHExportPDFBuilder createFieldsFmdFreqWaitingPeriod() throws HHExportException;

    HHExportPDFBuilder createFieldsProphyFreqCalender() throws HHExportException;

    HHExportPDFBuilder createFieldsArestinFreqPayorId() throws HHExportException;

    HHExportPDFBuilder createFieldsPerioFreqPaymentMade() throws HHExportException;

    HHExportPDFBuilder createImplants() throws HHExportException;

    HHExportPDFBuilder createNTIAndCovered() throws HHExportException;

    HHExportPDFBuilder createOralSurgeryAndDed() throws HHExportException;

    HHExportPDFBuilder createPalliativeTxAndOrtho() throws HHExportException;

    HHExportPDFBuilder createOccGuardAndAge() throws HHExportException;

    HHExportPDFBuilder createIsDownGradedAndMax() throws HHExportException;

    HHExportPDFBuilder createPADed() throws HHExportException;

}
