package com.hh.export.service.writer;

import com.hh.export.exception.HHExportException;
import com.hh.export.model.MDFReport;
import com.hh.export.reftype.YNStatus;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class is used to construct mdf forms in pdf format using user
 * exported form details. This implements PDF builder Interface and follows
 * Builder Pattern.
 *
 * @author Mohamed Riyas
 */
public class HHExportPDFBuilderService implements HHExportPDFBuilder {

    private static final int FORM_HEADER_FONT_SIZE = 10;
    private static final float START_OFFSET = 20;
    private static final String MEMBER_TEXT = "Member:";
    private static final String DATE = "Date:";
    private static final String SS_ID = "SS/ID# :";
    private static final String EFFEC_DATE = "Effec.Date :";
    private static final String DOB = "DOB :";
    private static final String SPOKE_TO = "Spoke To :";
    private static final String PT_DOB = "Pt & DOB :";
    private static final String BY = "By :";
    private static final String INSR_CO_FEE_SCHE = "Insurance Co/Fee Schedule:";
    private static final String GROUP = "Group # :";
    private static final String OON_ASSIGNMENT = "if OON-Assignment of benefits to : Provider or Patient";
    private static final String EMPLOYER = "Employer :";
    private static final String PHONE = "Phone# :";
    private static final String ADDRESS = "Address :";
    private static final String HISTORY = "History (Sealants,Pano,Bwx,Prophy,Exam) :";
    private static final String FREQUENCIES = "Frequencies :";
    private static final String YEARLY_MAX = "Yearly Max :";
    private static final String PROPHY = "Prophy :";
    private static final String USED_BENEFITS = "Used Benefits :";
    private static final String EXAMS = "Exams :";
    private static final String DED_MET = "Ded & Met (Y or N ) :";
    private static final String DED_APPLIES = "Ded. Applies :";
    private static final String BWX = "Bwx :";
    private static final String PREV = "Prev :";
    private static final String PANO = "Pano :";
    private static final String BASIC = "Basic :";
    private static final String FLOURIDE = "Flouride :";
    private static final String FREQ = "Freq :";
    private static final String AGE = "Age :";
    private static final String MAJOR = "Major :";
    private static final String SEALANTS = "Sealants :";
    private static final String CORE_BUILD_UP = "Core Build Up(2950) :";
    private static final String AGE_FOR_REPLACEMENT = "Age For Replacement :";
    private static final String PREFAB = "Prefab. Post & Core(2950) :";
    private static final String PAID_AT = "Paid at  Seat or Prep of Crown ?";
    private static final String ENDO = "Endo :";
    private static final String MISSING_TOOTH_CLAUSE = "Missing Tooth Clause :";
    private static final String SRP = "SRP(4341) :";
    private static final String MOLAR_PRE_MOLAR = "Molar /Pre-molar :";
    private static final String FMD = "FMD(4341) :";
    private static final String WAITING_PERIOD = "Waiting Period :";
    private static final String PROPHY_W_GINGIVITIS = "Prophy w/ Active Gingivitis(4346) :";
    private static final String CALENDER_OR_PLAN_YR = "Calender or Plan Yr :";
    private static final String ARESTIN = "Arestin(4381) :";
    private static final String PAYOR_ID = "Payor ID# :";
    private static final String PERIO_MAINT = "Perio. Maint.(4910) :";
    private static final String PAYMENT_MADE = "Payment Made :";
    private static final String IMPLANTS = "Implants :";
    private static final String NTI = "NTI(7880) :";
    private static final String COVERED = "%Covered :";
    private static final String ORAL_SURGERY = "Oral Surgery(7210) :";
    private static final String DED = "Ded :";
    private static final String PALLIATIVE_TX = "Palliative Tx(9110) :";
    private static final String ORTHO = "Ortho :";
    private static final String OCC_GUARD = "Occ. Guard(9944) :";
    private static final String DO_YOU_DOWNGRADED = "For composite fillings for back teeth do you downgrade?";
    private static final String MAX = "Max :";
    private static final String PA_DED = "PA's Ded :";

    private HHExportPdfCreatorService pdfCreator;

    private MDFReport mdfReport = null;
    private OutputStream os = null;
    private PDPageContentStream cos = null;
    private PDPage page = null;

    public HHExportPDFBuilderService(HHExportPdfCreatorService pdfCreator) {
        this.pdfCreator = pdfCreator;
    }

    @Override
    public HHExportPDFBuilder initialize(MDFReport mdfReport, OutputStream os) {
        this.mdfReport = mdfReport;
        this.os = os;
        return this;
    }

    @Override
    public void buildPDFWithFormContent() throws HHExportException {
        this.createPdfPage().createContentStream();
        this.createFieldMemberAndDate();
        this.createSSIDAndEffecDate();
        this.createDOBAndSpokeTo();
        this.createPTDOBAndBy();
        this.createInsrCoFeeScheAndGroup();
        this.createPhoneAndEmployer();
        this.createAddressAndHistory();
        this.createYearlyMaxAndProphy();
        this.createUsedBenefitsAndExams();
        this.createDedAndMedAndFreq();
        this.createDedAppAndBwx();
        this.createPrevAndPano();
        this.createFieldsBasicFluorideFreqAge();
        this.createFieldsMajorSealentsFreqAge();
        this.createCoreBuildUpAndAgeForReplace();
        this.createPrefabAndPaidAtSeat();
        this.createEndoAndMissingToothClause();
        this.createFieldsSrpFreqMolarOrPre();
        this.createFieldsFmdFreqWaitingPeriod();
        this.createFieldsProphyFreqCalender();
        this.createFieldsArestinFreqPayorId();
        this.createFieldsPerioFreqPaymentMade();
        this.createImplants();
        this.createNTIAndCovered();
        this.createOralSurgeryAndDed();
        this.createPalliativeTxAndOrtho();
        this.createOccGuardAndAge();
        this.createIsDownGradedAndMax();
        this.createPADed();
        this.cleanupResources();
        this.persistPdfOnStream();
    }

    @Override
    public HHExportPDFBuilder createPdfPage() {
        this.page = this.pdfCreator.addA4PageToPDF();
        return this;
    }

    @Override
    public HHExportPDFBuilder createContentStream() throws HHExportException {
        try {
            this.cos = this.pdfCreator.getContentStream(page);
        } catch (IOException ex) {
            throw new HHExportException(
                    "IO Exception Occurred while generating pdf form - ContentStream is not created", ex);
        }
        return this;
    }

    @Override
    public void cleanupResources() throws HHExportException {
        if (this.cos != null) {
            try {
                this.pdfCreator.closePageContentStream(cos);
            } catch (IOException ex) {
                this.cos = null;
                throw new HHExportException(
                        "IO Exception Occurred while generating pdf form - clean up content stream", ex);
            }
        }
    }

    @Override
    public void persistPdfOnStream() throws HHExportException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.pdfCreator.saveAsPdf(baos);
            baos.writeTo(this.os);
        } catch (IOException ex) {
            throw new HHExportException(
                    "Exception Occurred while generating pdf form - PDF Cannot be persisted on stream", ex);
        }
    }

    @Override
    public HHExportPDFBuilder createFieldMemberAndDate() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() + 800);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, MEMBER_TEXT, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPatientName(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DATE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            // TODO: Set Date here
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "04-09-2020", FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createSSIDAndEffecDate() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, SS_ID, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getIdNumberAndSSN(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, EFFEC_DATE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getEffectiveDate(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createDOBAndSpokeTo() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DOB, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPatientDOB(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, SPOKE_TO, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSubscriberName(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPTDOBAndBy() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PT_DOB, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPatientDOB(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, BY, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSubscriberName(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createInsrCoFeeScheAndGroup() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, INSR_CO_FEE_SCHE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 150, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getInsuranceName(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, GROUP, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getGroups(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 15);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, OON_ASSIGNMENT, FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPhoneAndEmployer() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PHONE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            // TODO: Correct the values here
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "8611166518", FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 200, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, EMPLOYER, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 250, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getEmployer(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createAddressAndHistory() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, ADDRESS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "PO BOX 188123", FORM_HEADER_FONT_SIZE);
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, HISTORY, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "Chattanooga TN: 34462-29132.", FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getExamFreqAndHistory(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createYearlyMaxAndProphy() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, YEARLY_MAX, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPlanYear(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PROPHY, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPlanYear(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createUsedBenefitsAndExams() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, USED_BENEFITS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getAnnualMaximumUsed(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, EXAMS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getExamFreqAndHistory(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createDedAndMedAndFreq() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DED_MET, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "40%", FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "60%", FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createDedAppAndBwx() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DED_APPLIES, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDeductibleApply(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, BWX, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getBasicAndMajorPreventive(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPrevAndPano() throws HHExportException {
        try {
            // TODO: Correct the values here
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PREV, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getBasicAndMajorPreventive().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PANO, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getBasicAndMajorPreventive().split(",")[1], FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsBasicFluorideFreqAge() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, BASIC, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 80, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getBasicAndMajorPreventive().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 160, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FLOURIDE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 240, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getFlourideAndFreqWithAge().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 320, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 380, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getFlourideAndFreqWithAge().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 440, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, AGE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 500, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getFlourideAndFreqWithAge().split(",")[2], FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsMajorSealentsFreqAge() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, MAJOR, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 80, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getBasicAndMajorPreventive().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 160, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, SEALANTS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 240, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSealentsAndFreqWithAgeAndHis().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 320, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 380, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSealentsAndFreqWithAgeAndHis().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 440, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, AGE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 500, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSealentsAndFreqWithAgeAndHis().split(",")[2], FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createCoreBuildUpAndAgeForReplace() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, CORE_BUILD_UP, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getCoreBuildUpAndFreq(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, AGE_FOR_REPLACEMENT, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getAgeForReplacement(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPrefabAndPaidAtSeat() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PREFAB, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 150, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPreFabricPostAndCore(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PAID_AT, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPaidOnPrepOrSeatDate(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createEndoAndMissingToothClause() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, ENDO, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getEndodontics(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, MISSING_TOOTH_CLAUSE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getMissingToothClause(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsSrpFreqMolarOrPre() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, SRP, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSrpAndFreqWithQuadPerDay().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 200, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 270, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getSrpAndFreqWithQuadPerDay().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 350, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, MOLAR_PRE_MOLAR, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            // TODO: Correct the value Here
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getAreCompositeDowngradedIncMolOrPreMol(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsFmdFreqWaitingPeriod() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FMD, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getFmdFreq().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 200, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 270, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getFmdFreq().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 350, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, WAITING_PERIOD, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getWaitingPeriod(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsProphyFreqCalender() throws HHExportException {
        try {
            // TODO: Replace with correct values
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PROPHY_W_GINGIVITIS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 150, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getArestinAndFreq().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 220, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 280, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getArestinAndFreq().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 350, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, CALENDER_OR_PLAN_YR, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getArestinAndFreq().split(",")[1], FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsArestinFreqPayorId() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, ARESTIN, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getArestinAndFreq().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 200, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 270, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getArestinAndFreq().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 350, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PAYOR_ID, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPayorIdNumber(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createFieldsPerioFreqPaymentMade() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PERIO_MAINT, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPerioMaintanenceAndFreqWithShare().split(",")[0], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 200, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, FREQ, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 270, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPerioMaintanenceAndFreqWithShare().split(",")[1], FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 350, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PAYMENT_MADE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 450, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPerioMaintanenceAndFreqWithShare().split(",")[2], FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createImplants() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, IMPLANTS, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getImplants(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createNTIAndCovered() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, NTI, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDoctorsNames(), FORM_HEADER_FONT_SIZE);//TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "200", FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, COVERED, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDoctorsNames(), FORM_HEADER_FONT_SIZE);//TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, YNStatus.NO.getDisplay(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createOralSurgeryAndDed() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, ORAL_SURGERY, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getOralSurgeryAndFreq(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DED, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDoctorsNames(), FORM_HEADER_FONT_SIZE);//TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getOrthodontics(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPalliativeTxAndOrtho() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PALLIATIVE_TX, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPalliativeTxAndFreq(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, ORTHO, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getOrthodontics(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createOccGuardAndAge() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, OCC_GUARD, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getOcclusionGuardsAndFreq(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, AGE, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDoctorsNames(), FORM_HEADER_FONT_SIZE);//TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, "20", FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createIsDownGradedAndMax() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, DO_YOU_DOWNGRADED, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, MAX, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getDoctorsNames(), FORM_HEADER_FONT_SIZE); //TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, YNStatus.NO.getDisplay(), FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 100, pdfCreator.getCurrentPosY() - 20);
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getAreCompositeDowngradedIncMolOrPreMol(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }

    @Override
    public HHExportPDFBuilder createPADed() throws HHExportException {
        try {
            pdfCreator.setCurrentPos(START_OFFSET + 300, pdfCreator.getCurrentPosY());
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, PA_DED, FORM_HEADER_FONT_SIZE);
            pdfCreator.setCurrentPos(START_OFFSET + 400, pdfCreator.getCurrentPosY());
            //pdfCreator.createHeaderTextByTB(cos, Color.BLACK, this.mdfReport.getPeriapicalXRayAndFreq(), FORM_HEADER_FONT_SIZE); //TODO: Replacce with correct field
            pdfCreator.createHeaderTextByTB(cos, Color.BLACK, YNStatus.NO.getDisplay(), FORM_HEADER_FONT_SIZE);
        } catch (IOException ex) {
            throw new HHExportException("IO Exception Occurred while generating pdf form - Personal Header", ex);
        }
        return this;
    }


}
