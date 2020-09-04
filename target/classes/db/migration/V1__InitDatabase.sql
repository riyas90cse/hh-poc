ALTER DATABASE `EXPORT_HH` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `EXPORT_HH`;

CREATE TABLE IF NOT EXISTS `MDF_REPORT` (
   `ID` BIGINT NOT NULL AUTO_INCREMENT,
   NO_OF_APPOINTMENTS VARCHAR(200) NOT NULL,
   DOCTORS_NAMES VARCHAR(200) NOT NULL,
   ELIG_VER_INDICATION VARCHAR(200) NOT NULL,
   PATIENT_NAME VARCHAR(200) NOT NULL,
   PATIENT_DOB VARCHAR(200) NOT NULL,
   SUBSCRIBER_NAME VARCHAR(200) NOT NULL,
   SUBSCRIBER_DOB VARCHAR(200) NOT NULL,
   RELATIONSHIP VARCHAR(200) NOT NULL,
   ID_NUMBER_AND_SSN VARCHAR(200) NOT NULL,
   INSURANCE_NAME VARCHAR(200) NOT NULL,
   INSURANCE_TEL VARCHAR(200) NOT NULL,
   GROUPS_P VARCHAR(200) NOT NULL,
   PAYOR_ID_NUMBER VARCHAR(200) NOT NULL,
   EMPLOYER VARCHAR(200) NOT NULL,
   PLAN_YEAR VARCHAR(200) NOT NULL,
   EFFECTIVE_DATE VARCHAR(200) NOT NULL,
   FEE_SCHEDULE_NAME VARCHAR(200) NOT NULL,
   IS_PARTICIPATE VARCHAR(200) NOT NULL,
   INSR_BILL_ADDRESS VARCHAR(200) NOT NULL,
   INSR_REP_NAME_AND_CALL_REF VARCHAR(200) NOT NULL,
   ANNUAL_MAXIMUM VARCHAR(200) NOT NULL,
   ANNUAL_MAXIMUM_USED VARCHAR(200) NOT NULL,
   ANNUAL_MAXIMUM_LEFT VARCHAR(200) NOT NULL,
   INDIVIDUAL_DEDUCTIBLE VARCHAR(200) NOT NULL,
   FAMILY_DEDUCTIBLE VARCHAR(200) NOT NULL,
   DEDUCTIBLE_APPLY VARCHAR(200) NOT NULL,
   BASIC_AND_MAJOR_PREVENTIVE VARCHAR(200) NOT NULL,
   EXAM_FREQ_AND_HISTORY VARCHAR(200) NOT NULL,
   LOE_FREQ VARCHAR(200) NOT NULL,
   CHILD VARCHAR(200) NOT NULL,
   FLOURIDE_AND_FREQ_WITH_AGE VARCHAR(200) NOT NULL,
   SEALENTS_AND_FREQ_WITH_AGE_AND_HIS VARCHAR(200) NOT NULL,
   BITE_WINGS_AND_FREQ_WITH_AGE_AND_HIS VARCHAR(200) NOT NULL,
   PANO_FMX_AND_FREQ_WITH_AGE_AND_HIS VARCHAR(200) NOT NULL,
   PERIAPICAL_X_RAY_AND_FREQ VARCHAR(200) NOT NULL,
   PALLIATIVE_TX_AND_FREQ VARCHAR(200) NOT NULL,
   ARE_COMPOSITE_DOWNGRADED_INC_MOL_OR_PRE_MOL VARCHAR(200) NOT NULL,
   CORE_BUILD_UP_AND_FREQ VARCHAR(200) NOT NULL,
   PRE_FABRIC_POST_AND_CORE VARCHAR(200) NOT NULL,
   IMPLANTS VARCHAR(200) NOT NULL,
   ARE_CROMNS_DOWNGRADED VARCHAR(200) NOT NULL,
   AGE_FOR_REPLACEMENT VARCHAR(200) NOT NULL,
   PAID_ON_PREP_OR_SEAT_DATE VARCHAR(200) NOT NULL,
   WAITING_PERIOD VARCHAR(200) NOT NULL,
   MISSING_TOOTH_CLAUSE VARCHAR(200) NOT NULL,
   ENDODONTICS VARCHAR(200) NOT NULL,
   SRP_AND_FREQ_WITH_QUAD_PER_DAY VARCHAR(200) NOT NULL,
   FMD_FREQ VARCHAR(200) NOT NULL,
   GINGIVITIS_AND_FREQ VARCHAR(200) NOT NULL,
   PERIO_MAINTANENCE_AND_FREQ_WITH_SHARE VARCHAR(200) NOT NULL,
   ARESTIN_AND_FREQ VARCHAR(200) NOT NULL,
   TMJ_AND_FREQ VARCHAR(200) NOT NULL,
   ORAL_SURGERY_AND_FREQ VARCHAR(200) NOT NULL,
   OCCLUSION_GUARDS_AND_FREQ VARCHAR(200) NOT NULL,
   ORTHODONTICS VARCHAR(200) NOT NULL,
   ORTHO_LIFETIME_MAX_AND_AGE_LIMIT VARCHAR(200) NOT NULL,
   ORTHO_DEDUCTIBLE VARCHAR(200) NOT NULL,
   ORTHO_PAYMENT_MADE VARCHAR(200) NOT NULL,
   CREATED_BY VARCHAR(200) NOT NULL,
   CREATED_DATE DATETIME NOT NULL,
   UPDATED_BY VARCHAR(200) NOT NULL,
   UPDATED_DATE DATETIME NOT NULL,
   DELETED VARCHAR(1) NOT NULL,
   PRIMARY KEY (`ID`)
) ENGINE=INNODB  DEFAULT CHARSET=UTF8;

CREATE INDEX `MDF_REP_IND` ON `MDF_REPORT` (PATIENT_NAME, DELETED);
