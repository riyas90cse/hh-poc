package com.hh.export.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Mohamed Riyas
 */
@Entity
@Table(name = "MDF_REPORT")
public class MDFReport {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NO_OF_APPOINTMENTS")
    private String noOfAppointments;
    @Column(name = "DOCTORS_NAMES")
    private String doctorsNames;
    @Column(name = "ELIG_VER_INDICATION")
    private String eilgVerIndication;
    @Column(name = "PATIENT_NAME")
    private String patientName;
    @Column(name = "PATIENT_DOB")
    private String patientDOB;
    @Column(name = "SUBSCRIBER_NAME")
    private String subscriberName;
    @Column(name = "SUBSCRIBER_DOB")
    private String subscriberDOB;
    @Column(name = "RELATIONSHIP")
    private String relationship;
    @Column(name = "ID_NUMBER_AND_SSN")
    private String idNumberAndSSN;
    @Column(name = "INSURANCE_NAME")
    private String insuranceName;
    @Column(name = "INSURANCE_TEL")
    private String insuranceTel;
    @Column(name = "GROUPS_P")
    private String groups;
    @Column(name = "PAYOR_ID_NUMBER")
    private String payorIdNumber;
    @Column(name = "EMPLOYER")
    private String employer;
    @Column(name = "PLAN_YEAR")
    private String planYear;
    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate;
    @Column(name = "FEE_SCHEDULE_NAME")
    private String feeScheduleName;
    @Column(name = "IS_PARTICIPATE")
    private String isParticipate;
    @Column(name = "INSR_BILL_ADDRESS")
    private String insrBillAddress;
    @Column(name = "INSR_REP_NAME_AND_CALL_REF")
    private String insrRepNameAndCallRef;
    @Column(name = "ANNUAL_MAXIMUM")
    private String annualMaximum;
    @Column(name = "ANNUAL_MAXIMUM_USED")
    private String annualMaximumUsed;
    @Column(name = "ANNUAL_MAXIMUM_LEFT")
    private String annualMaximumLeft;
    @Column(name = "INDIVIDUAL_DEDUCTIBLE")
    private String individualDeductible;
    @Column(name = "FAMILY_DEDUCTIBLE")
    private String familyDeductible;
    @Column(name = "DEDUCTIBLE_APPLY")
    private String deductibleApply;
    @Column(name = "BASIC_AND_MAJOR_PREVENTIVE")
    private String basicAndMajorPreventive;
    @Column(name = "EXAM_FREQ_AND_HISTORY")
    private String examFreqAndHistory;
    @Column(name = "LOE_FREQ")
    private String loeFreq;
    @Column(name = "CHILD")
    private String child;
    @Column(name = "FLOURIDE_AND_FREQ_WITH_AGE")
    private String flourideAndFreqWithAge;
    @Column(name = "SEALENTS_AND_FREQ_WITH_AGE_AND_HIS")
    private String sealentsAndFreqWithAgeAndHis;
    @Column(name = "BITE_WINGS_AND_FREQ_WITH_AGE_AND_HIS")
    private String biteWingsAndFreqWithAgeAndHis;
    @Column(name = "PANO_FMX_AND_FREQ_WITH_AGE_AND_HIS")
    private String panoFmxAndFreqWithAgeAndHis;
    @Column(name = "PERIAPICAL_X_RAY_AND_FREQ")
    private String periapicalXRayAndFreq;
    @Column(name = "PALLIATIVE_TX_AND_FREQ")
    private String palliativeTxAndFreq;
    @Column(name = "ARE_COMPOSITE_DOWNGRADED_INC_MOL_OR_PRE_MOL")
    private String areCompositeDowngradedIncMolOrPreMol;
    @Column(name = "CORE_BUILD_UP_AND_FREQ")
    private String coreBuildUpAndFreq;
    @Column(name = "PRE_FABRIC_POST_AND_CORE")
    private String preFabricPostAndCore;
    @Column(name = "IMPLANTS")
    private String implants;
    @Column(name = "ARE_CROMNS_DOWNGRADED")
    private String areCrownsDowngraded;
    @Column(name = "AGE_FOR_REPLACEMENT")
    private String ageForReplacement;
    @Column(name = "PAID_ON_PREP_OR_SEAT_DATE")
    private String paidOnPrepOrSeatDate;
    @Column(name = "WAITING_PERIOD")
    private String waitingPeriod;
    @Column(name = "MISSING_TOOTH_CLAUSE")
    private String missingToothClause;
    @Column(name = "ENDODONTICS")
    private String endodontics;
    @Column(name = "SRP_AND_FREQ_WITH_QUAD_PER_DAY")
    private String srpAndFreqWithQuadPerDay;
    @Column(name = "FMD_FREQ")
    private String fmdFreq;
    @Column(name = "GINGIVITIS_AND_FREQ")
    private String gingivitisAndFreq;
    @Column(name = "PERIO_MAINTANENCE_AND_FREQ_WITH_SHARE")
    private String perioMaintanenceAndFreqWithShare;
    @Column(name = "ARESTIN_AND_FREQ")
    private String arestinAndFreq;
    @Column(name = "TMJ_AND_FREQ")
    private String tmjAndFreq;
    @Column(name = "ORAL_SURGERY_AND_FREQ")
    private String oralSurgeryAndFreq;
    @Column(name = "OCCLUSION_GUARDS_AND_FREQ")
    private String occlusionGuardsAndFreq;
    @Column(name = "ORTHODONTICS")
    private String orthodontics;
    @Column(name = "ORTHO_LIFETIME_MAX_AND_AGE_LIMIT")
    private String orthoLifetimeMaxAndAgeLimit;
    @Column(name = "ORTHO_DEDUCTIBLE")
    private String orthoDeductible;
    @Column(name = "ORTHO_PAYMENT_MADE")
    private String orthoPaymentMade;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
    @Column(name = "DELETED")
    private String deleted;

    public MDFReport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoOfAppointments() {
        return noOfAppointments;
    }

    public void setNoOfAppointments(String noOfAppointments) {
        this.noOfAppointments = noOfAppointments;
    }

    public String getDoctorsNames() {
        return doctorsNames;
    }

    public void setDoctorsNames(String doctorsNames) {
        this.doctorsNames = doctorsNames;
    }

    public String getEilgVerIndication() {
        return eilgVerIndication;
    }

    public void setEilgVerIndication(String eilgVerIndication) {
        this.eilgVerIndication = eilgVerIndication;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberDOB() {
        return subscriberDOB;
    }

    public void setSubscriberDOB(String subscriberDOB) {
        this.subscriberDOB = subscriberDOB;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getIdNumberAndSSN() {
        return idNumberAndSSN;
    }

    public void setIdNumberAndSSN(String idNumberAndSSN) {
        this.idNumberAndSSN = idNumberAndSSN;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceTel() {
        return insuranceTel;
    }

    public void setInsuranceTel(String insuranceTel) {
        this.insuranceTel = insuranceTel;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getPayorIdNumber() {
        return payorIdNumber;
    }

    public void setPayorIdNumber(String payorIdNumber) {
        this.payorIdNumber = payorIdNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPlanYear() {
        return planYear;
    }

    public void setPlanYear(String planYear) {
        this.planYear = planYear;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getFeeScheduleName() {
        return feeScheduleName;
    }

    public void setFeeScheduleName(String feeScheduleName) {
        this.feeScheduleName = feeScheduleName;
    }

    public String getIsParticipate() {
        return isParticipate;
    }

    public void setIsParticipate(String isParticipate) {
        this.isParticipate = isParticipate;
    }

    public String getInsrBillAddress() {
        return insrBillAddress;
    }

    public void setInsrBillAddress(String insrBillAddress) {
        this.insrBillAddress = insrBillAddress;
    }

    public String getInsrRepNameAndCallRef() {
        return insrRepNameAndCallRef;
    }

    public void setInsrRepNameAndCallRef(String insrRepNameAndCallRef) {
        this.insrRepNameAndCallRef = insrRepNameAndCallRef;
    }

    public String getAnnualMaximum() {
        return annualMaximum;
    }

    public void setAnnualMaximum(String annualMaximum) {
        this.annualMaximum = annualMaximum;
    }

    public String getAnnualMaximumUsed() {
        return annualMaximumUsed;
    }

    public void setAnnualMaximumUsed(String annualMaximumUsed) {
        this.annualMaximumUsed = annualMaximumUsed;
    }

    public String getAnnualMaximumLeft() {
        return annualMaximumLeft;
    }

    public void setAnnualMaximumLeft(String annualMaximumLeft) {
        this.annualMaximumLeft = annualMaximumLeft;
    }

    public String getIndividualDeductible() {
        return individualDeductible;
    }

    public void setIndividualDeductible(String individualDeductible) {
        this.individualDeductible = individualDeductible;
    }

    public String getFamilyDeductible() {
        return familyDeductible;
    }

    public void setFamilyDeductible(String familyDeductible) {
        this.familyDeductible = familyDeductible;
    }

    public String getDeductibleApply() {
        return deductibleApply;
    }

    public void setDeductibleApply(String deductibleApply) {
        this.deductibleApply = deductibleApply;
    }

    public String getBasicAndMajorPreventive() {
        return basicAndMajorPreventive;
    }

    public void setBasicAndMajorPreventive(String basicAndMajorPreventive) {
        this.basicAndMajorPreventive = basicAndMajorPreventive;
    }

    public String getExamFreqAndHistory() {
        return examFreqAndHistory;
    }

    public void setExamFreqAndHistory(String examFreqAndHistory) {
        this.examFreqAndHistory = examFreqAndHistory;
    }

    public String getLoeFreq() {
        return loeFreq;
    }

    public void setLoeFreq(String loeFreq) {
        this.loeFreq = loeFreq;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getFlourideAndFreqWithAge() {
        return flourideAndFreqWithAge;
    }

    public void setFlourideAndFreqWithAge(String flourideAndFreqWithAge) {
        this.flourideAndFreqWithAge = flourideAndFreqWithAge;
    }

    public String getSealentsAndFreqWithAgeAndHis() {
        return sealentsAndFreqWithAgeAndHis;
    }

    public void setSealentsAndFreqWithAgeAndHis(String sealentsAndFreqWithAgeAndHis) {
        this.sealentsAndFreqWithAgeAndHis = sealentsAndFreqWithAgeAndHis;
    }

    public String getBiteWingsAndFreqWithAgeAndHis() {
        return biteWingsAndFreqWithAgeAndHis;
    }

    public void setBiteWingsAndFreqWithAgeAndHis(String biteWingsAndFreqWithAgeAndHis) {
        this.biteWingsAndFreqWithAgeAndHis = biteWingsAndFreqWithAgeAndHis;
    }

    public String getPanoFmxAndFreqWithAgeAndHis() {
        return panoFmxAndFreqWithAgeAndHis;
    }

    public void setPanoFmxAndFreqWithAgeAndHis(String panoFmxAndFreqWithAgeAndHis) {
        this.panoFmxAndFreqWithAgeAndHis = panoFmxAndFreqWithAgeAndHis;
    }

    public String getPeriapicalXRayAndFreq() {
        return periapicalXRayAndFreq;
    }

    public void setPeriapicalXRayAndFreq(String periapicalXRayAndFreq) {
        this.periapicalXRayAndFreq = periapicalXRayAndFreq;
    }

    public String getPalliativeTxAndFreq() {
        return palliativeTxAndFreq;
    }

    public void setPalliativeTxAndFreq(String palliativeTxAndFreq) {
        this.palliativeTxAndFreq = palliativeTxAndFreq;
    }

    public String getAreCompositeDowngradedIncMolOrPreMol() {
        return areCompositeDowngradedIncMolOrPreMol;
    }

    public void setAreCompositeDowngradedIncMolOrPreMol(String areCompositeDowngradedIncMolOrPreMol) {
        this.areCompositeDowngradedIncMolOrPreMol = areCompositeDowngradedIncMolOrPreMol;
    }

    public String getCoreBuildUpAndFreq() {
        return coreBuildUpAndFreq;
    }

    public void setCoreBuildUpAndFreq(String coreBuildUpAndFreq) {
        this.coreBuildUpAndFreq = coreBuildUpAndFreq;
    }

    public String getPreFabricPostAndCore() {
        return preFabricPostAndCore;
    }

    public void setPreFabricPostAndCore(String preFabricPostAndCore) {
        this.preFabricPostAndCore = preFabricPostAndCore;
    }

    public String getImplants() {
        return implants;
    }

    public void setImplants(String implants) {
        this.implants = implants;
    }

    public String getAreCrownsDowngraded() {
        return areCrownsDowngraded;
    }

    public void setAreCrownsDowngraded(String areCrownsDowngraded) {
        this.areCrownsDowngraded = areCrownsDowngraded;
    }

    public String getAgeForReplacement() {
        return ageForReplacement;
    }

    public void setAgeForReplacement(String ageForReplacement) {
        this.ageForReplacement = ageForReplacement;
    }

    public String getPaidOnPrepOrSeatDate() {
        return paidOnPrepOrSeatDate;
    }

    public void setPaidOnPrepOrSeatDate(String paidOnPrepOrSeatDate) {
        this.paidOnPrepOrSeatDate = paidOnPrepOrSeatDate;
    }

    public String getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(String waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public String getMissingToothClause() {
        return missingToothClause;
    }

    public void setMissingToothClause(String missingToothClause) {
        this.missingToothClause = missingToothClause;
    }

    public String getEndodontics() {
        return endodontics;
    }

    public void setEndodontics(String endodontics) {
        this.endodontics = endodontics;
    }

    public String getSrpAndFreqWithQuadPerDay() {
        return srpAndFreqWithQuadPerDay;
    }

    public void setSrpAndFreqWithQuadPerDay(String srpAndFreqWithQuadPerDay) {
        this.srpAndFreqWithQuadPerDay = srpAndFreqWithQuadPerDay;
    }

    public String getFmdFreq() {
        return fmdFreq;
    }

    public void setFmdFreq(String fmdFreq) {
        this.fmdFreq = fmdFreq;
    }

    public String getGingivitisAndFreq() {
        return gingivitisAndFreq;
    }

    public void setGingivitisAndFreq(String gingivitisAndFreq) {
        this.gingivitisAndFreq = gingivitisAndFreq;
    }

    public String getPerioMaintanenceAndFreqWithShare() {
        return perioMaintanenceAndFreqWithShare;
    }

    public void setPerioMaintanenceAndFreqWithShare(String perioMaintanenceAndFreqWithShare) {
        this.perioMaintanenceAndFreqWithShare = perioMaintanenceAndFreqWithShare;
    }

    public String getArestinAndFreq() {
        return arestinAndFreq;
    }

    public void setArestinAndFreq(String arestinAndFreq) {
        this.arestinAndFreq = arestinAndFreq;
    }

    public String getTmjAndFreq() {
        return tmjAndFreq;
    }

    public void setTmjAndFreq(String tmjAndFreq) {
        this.tmjAndFreq = tmjAndFreq;
    }

    public String getOralSurgeryAndFreq() {
        return oralSurgeryAndFreq;
    }

    public void setOralSurgeryAndFreq(String oralSurgeryAndFreq) {
        this.oralSurgeryAndFreq = oralSurgeryAndFreq;
    }

    public String getOcclusionGuardsAndFreq() {
        return occlusionGuardsAndFreq;
    }

    public void setOcclusionGuardsAndFreq(String occlusionGuardsAndFreq) {
        this.occlusionGuardsAndFreq = occlusionGuardsAndFreq;
    }

    public String getOrthodontics() {
        return orthodontics;
    }

    public void setOrthodontics(String orthodontics) {
        this.orthodontics = orthodontics;
    }

    public String getOrthoLifetimeMaxAndAgeLimit() {
        return orthoLifetimeMaxAndAgeLimit;
    }

    public void setOrthoLifetimeMaxAndAgeLimit(String orthoLifetimeMaxAndAgeLimit) {
        this.orthoLifetimeMaxAndAgeLimit = orthoLifetimeMaxAndAgeLimit;
    }

    public String getOrthoDeductible() {
        return orthoDeductible;
    }

    public void setOrthoDeductible(String orthoDeductible) {
        this.orthoDeductible = orthoDeductible;
    }

    public String getOrthoPaymentMade() {
        return orthoPaymentMade;
    }

    public void setOrthoPaymentMade(String orthoPaymentMade) {
        this.orthoPaymentMade = orthoPaymentMade;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MDFReport mdfReport = (MDFReport) o;
        return Objects.equals(id, mdfReport.id) &&
                Objects.equals(noOfAppointments, mdfReport.noOfAppointments) &&
                Objects.equals(doctorsNames, mdfReport.doctorsNames) &&
                Objects.equals(eilgVerIndication, mdfReport.eilgVerIndication) &&
                Objects.equals(patientName, mdfReport.patientName) &&
                Objects.equals(patientDOB, mdfReport.patientDOB) &&
                Objects.equals(subscriberName, mdfReport.subscriberName) &&
                Objects.equals(subscriberDOB, mdfReport.subscriberDOB) &&
                Objects.equals(relationship, mdfReport.relationship) &&
                Objects.equals(idNumberAndSSN, mdfReport.idNumberAndSSN) &&
                Objects.equals(insuranceName, mdfReport.insuranceName) &&
                Objects.equals(insuranceTel, mdfReport.insuranceTel) &&
                Objects.equals(groups, mdfReport.groups) &&
                Objects.equals(payorIdNumber, mdfReport.payorIdNumber) &&
                Objects.equals(employer, mdfReport.employer) &&
                Objects.equals(planYear, mdfReport.planYear) &&
                Objects.equals(effectiveDate, mdfReport.effectiveDate) &&
                Objects.equals(feeScheduleName, mdfReport.feeScheduleName) &&
                Objects.equals(isParticipate, mdfReport.isParticipate) &&
                Objects.equals(insrBillAddress, mdfReport.insrBillAddress) &&
                Objects.equals(insrRepNameAndCallRef, mdfReport.insrRepNameAndCallRef) &&
                Objects.equals(annualMaximum, mdfReport.annualMaximum) &&
                Objects.equals(annualMaximumUsed, mdfReport.annualMaximumUsed) &&
                Objects.equals(annualMaximumLeft, mdfReport.annualMaximumLeft) &&
                Objects.equals(individualDeductible, mdfReport.individualDeductible) &&
                Objects.equals(familyDeductible, mdfReport.familyDeductible) &&
                Objects.equals(deductibleApply, mdfReport.deductibleApply) &&
                Objects.equals(basicAndMajorPreventive, mdfReport.basicAndMajorPreventive) &&
                Objects.equals(examFreqAndHistory, mdfReport.examFreqAndHistory) &&
                Objects.equals(loeFreq, mdfReport.loeFreq) &&
                Objects.equals(child, mdfReport.child) &&
                Objects.equals(flourideAndFreqWithAge, mdfReport.flourideAndFreqWithAge) &&
                Objects.equals(sealentsAndFreqWithAgeAndHis, mdfReport.sealentsAndFreqWithAgeAndHis) &&
                Objects.equals(biteWingsAndFreqWithAgeAndHis, mdfReport.biteWingsAndFreqWithAgeAndHis) &&
                Objects.equals(panoFmxAndFreqWithAgeAndHis, mdfReport.panoFmxAndFreqWithAgeAndHis) &&
                Objects.equals(periapicalXRayAndFreq, mdfReport.periapicalXRayAndFreq) &&
                Objects.equals(palliativeTxAndFreq, mdfReport.palliativeTxAndFreq) &&
                Objects.equals(areCompositeDowngradedIncMolOrPreMol, mdfReport.areCompositeDowngradedIncMolOrPreMol) &&
                Objects.equals(coreBuildUpAndFreq, mdfReport.coreBuildUpAndFreq) &&
                Objects.equals(preFabricPostAndCore, mdfReport.preFabricPostAndCore) &&
                Objects.equals(implants, mdfReport.implants) &&
                Objects.equals(areCrownsDowngraded, mdfReport.areCrownsDowngraded) &&
                Objects.equals(ageForReplacement, mdfReport.ageForReplacement) &&
                Objects.equals(paidOnPrepOrSeatDate, mdfReport.paidOnPrepOrSeatDate) &&
                Objects.equals(waitingPeriod, mdfReport.waitingPeriod) &&
                Objects.equals(missingToothClause, mdfReport.missingToothClause) &&
                Objects.equals(endodontics, mdfReport.endodontics) &&
                Objects.equals(srpAndFreqWithQuadPerDay, mdfReport.srpAndFreqWithQuadPerDay) &&
                Objects.equals(fmdFreq, mdfReport.fmdFreq) &&
                Objects.equals(gingivitisAndFreq, mdfReport.gingivitisAndFreq) &&
                Objects.equals(perioMaintanenceAndFreqWithShare, mdfReport.perioMaintanenceAndFreqWithShare) &&
                Objects.equals(arestinAndFreq, mdfReport.arestinAndFreq) &&
                Objects.equals(tmjAndFreq, mdfReport.tmjAndFreq) &&
                Objects.equals(oralSurgeryAndFreq, mdfReport.oralSurgeryAndFreq) &&
                Objects.equals(occlusionGuardsAndFreq, mdfReport.occlusionGuardsAndFreq) &&
                Objects.equals(orthodontics, mdfReport.orthodontics) &&
                Objects.equals(orthoLifetimeMaxAndAgeLimit, mdfReport.orthoLifetimeMaxAndAgeLimit) &&
                Objects.equals(orthoDeductible, mdfReport.orthoDeductible) &&
                Objects.equals(orthoPaymentMade, mdfReport.orthoPaymentMade)
                && Objects.equals(createdBy, mdfReport.createdBy)
                && Objects.equals(createdDate, mdfReport.createdDate)
                && Objects.equals(updatedBy, mdfReport.updatedBy)
                && Objects.equals(updatedDate, mdfReport.updatedDate)
                && Objects.equals(deleted, mdfReport.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noOfAppointments, doctorsNames, eilgVerIndication, patientName, patientDOB, subscriberName, subscriberDOB, relationship, idNumberAndSSN, insuranceName, insuranceTel, groups, payorIdNumber, employer, planYear, effectiveDate, feeScheduleName, isParticipate, insrBillAddress, insrRepNameAndCallRef, annualMaximum, annualMaximumUsed, annualMaximumLeft, individualDeductible, familyDeductible, deductibleApply, basicAndMajorPreventive, examFreqAndHistory, loeFreq, child, flourideAndFreqWithAge, sealentsAndFreqWithAgeAndHis, biteWingsAndFreqWithAgeAndHis, panoFmxAndFreqWithAgeAndHis, periapicalXRayAndFreq, palliativeTxAndFreq, areCompositeDowngradedIncMolOrPreMol, coreBuildUpAndFreq, preFabricPostAndCore, implants, areCrownsDowngraded, ageForReplacement, paidOnPrepOrSeatDate, waitingPeriod, missingToothClause, endodontics, srpAndFreqWithQuadPerDay, fmdFreq, gingivitisAndFreq, perioMaintanenceAndFreqWithShare, arestinAndFreq, tmjAndFreq, oralSurgeryAndFreq, occlusionGuardsAndFreq, orthodontics, orthoLifetimeMaxAndAgeLimit, orthoDeductible, orthoPaymentMade, createdBy, createdDate, updatedBy, updatedDate, deleted);
    }

    @Override
    public String toString() {
        return "MDFReport{" +
                "id=" + id +
                ", noOfAppointments='" + noOfAppointments + '\'' +
                ", doctorsNames='" + doctorsNames + '\'' +
                ", eilgVerIndication='" + eilgVerIndication + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientDOB='" + patientDOB + '\'' +
                ", subscriberName='" + subscriberName + '\'' +
                ", subscriberDOB='" + subscriberDOB + '\'' +
                ", relationship='" + relationship + '\'' +
                ", idNumberAndSSN='" + idNumberAndSSN + '\'' +
                ", insuranceName='" + insuranceName + '\'' +
                ", insuranceTel='" + insuranceTel + '\'' +
                ", groups='" + groups + '\'' +
                ", payorIdNumber='" + payorIdNumber + '\'' +
                ", employer='" + employer + '\'' +
                ", planYear='" + planYear + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", feeScheduleName='" + feeScheduleName + '\'' +
                ", isParticipate='" + isParticipate + '\'' +
                ", insrBillAddress='" + insrBillAddress + '\'' +
                ", insrRepNameAndCallRef='" + insrRepNameAndCallRef + '\'' +
                ", annualMaximum='" + annualMaximum + '\'' +
                ", annualMaximumUsed='" + annualMaximumUsed + '\'' +
                ", annualMaximumLeft='" + annualMaximumLeft + '\'' +
                ", individualDeductible='" + individualDeductible + '\'' +
                ", familyDeductible='" + familyDeductible + '\'' +
                ", deductibleApply='" + deductibleApply + '\'' +
                ", basicAndMajorPreventive='" + basicAndMajorPreventive + '\'' +
                ", examFreqAndHistory='" + examFreqAndHistory + '\'' +
                ", loeFreq='" + loeFreq + '\'' +
                ", child='" + child + '\'' +
                ", flourideAndFreqWithAge='" + flourideAndFreqWithAge + '\'' +
                ", sealentsAndFreqWithAgeAndHis='" + sealentsAndFreqWithAgeAndHis + '\'' +
                ", biteWingsAndFreqWithAgeAndHis='" + biteWingsAndFreqWithAgeAndHis + '\'' +
                ", panoFmxAndFreqWithAgeAndHis='" + panoFmxAndFreqWithAgeAndHis + '\'' +
                ", periapicalXRayAndFreq='" + periapicalXRayAndFreq + '\'' +
                ", palliativeTxAndFreq='" + palliativeTxAndFreq + '\'' +
                ", areCompositeDowngradedIncMolOrPreMol='" + areCompositeDowngradedIncMolOrPreMol + '\'' +
                ", coreBuildUpAndFreq='" + coreBuildUpAndFreq + '\'' +
                ", preFabricPostAndCore='" + preFabricPostAndCore + '\'' +
                ", implants='" + implants + '\'' +
                ", areCrownsDowngraded='" + areCrownsDowngraded + '\'' +
                ", ageForReplacement='" + ageForReplacement + '\'' +
                ", paidOnPrepOrSeatDate='" + paidOnPrepOrSeatDate + '\'' +
                ", waitingPeriod='" + waitingPeriod + '\'' +
                ", missingToothClause='" + missingToothClause + '\'' +
                ", endodontics='" + endodontics + '\'' +
                ", srpAndFreqWithQuadPerDay='" + srpAndFreqWithQuadPerDay + '\'' +
                ", fmdFreq='" + fmdFreq + '\'' +
                ", gingivitisAndFreq='" + gingivitisAndFreq + '\'' +
                ", perioMaintanenceAndFreqWithShare='" + perioMaintanenceAndFreqWithShare + '\'' +
                ", arestinAndFreq='" + arestinAndFreq + '\'' +
                ", tmjAndFreq='" + tmjAndFreq + '\'' +
                ", oralSurgeryAndFreq='" + oralSurgeryAndFreq + '\'' +
                ", occlusionGuardsAndFreq='" + occlusionGuardsAndFreq + '\'' +
                ", orthodontics='" + orthodontics + '\'' +
                ", orthoLifetimeMaxAndAgeLimit='" + orthoLifetimeMaxAndAgeLimit + '\'' +
                ", orthoDeductible='" + orthoDeductible + '\'' +
                ", orthoPaymentMade='" + orthoPaymentMade + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
