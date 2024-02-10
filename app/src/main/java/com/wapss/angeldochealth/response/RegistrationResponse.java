package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("reg_number")
    @Expose
    private String regNumber;
    @SerializedName("council_number")
    @Expose
    private String councilNumber;
    @SerializedName("reg_year")
    @Expose
    private Integer regYear;
    @SerializedName("experience")
    @Expose
    private Integer experience;
    @SerializedName("reg_type")
    @Expose
    private String regType;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("profileName")
    @Expose
    private String profileName;
    @SerializedName("signature")
    @Expose
    private String signature;
    @SerializedName("signatureName")
    @Expose
    private String signatureName;
    @SerializedName("expertise")
    @Expose
    private String expertise;
    @SerializedName("associated_hospital")
    @Expose
    private String associatedHospital;
    @SerializedName("degree_hospital")
    @Expose
    private String degreeHospital;
    @SerializedName("degree")
    @Expose
    private String degree;
    @SerializedName("e_medical")
    @Expose
    private Boolean eMedical;
    @SerializedName("telemedicine_fee")
    @Expose
    private Integer telemedicineFee;
    @SerializedName("in_persion_fee")
    @Expose
    private Integer inPersionFee;
    @SerializedName("e_board_fee")
    @Expose
    private Integer eBoardFee;
    @SerializedName("provide_telemedicine")
    @Expose
    private Boolean provideTelemedicine;
    @SerializedName("provide_in_persion")
    @Expose
    private Boolean provideInPersion;
    @SerializedName("provide_live_doctor")
    @Expose
    private Boolean provideLiveDoctor;
    @SerializedName("live_doctor_fee")
    @Expose
    private Integer liveDoctorFee;
    @SerializedName("expert_for_assessment")
    @Expose
    private Boolean expertForAssessment;
    @SerializedName("max_free_followup_days")
    @Expose
    private Integer maxFreeFollowupDays;
    @SerializedName("max_patient_limit")
    @Expose
    private Integer maxPatientLimit;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("updatedBy")
    @Expose
    private Integer updatedBy;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getCouncilNumber() {
        return councilNumber;
    }

    public void setCouncilNumber(String councilNumber) {
        this.councilNumber = councilNumber;
    }

    public Integer getRegYear() {
        return regYear;
    }

    public void setRegYear(Integer regYear) {
        this.regYear = regYear;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAssociatedHospital() {
        return associatedHospital;
    }

    public void setAssociatedHospital(String associatedHospital) {
        this.associatedHospital = associatedHospital;
    }

    public String getDegreeHospital() {
        return degreeHospital;
    }

    public void setDegreeHospital(String degreeHospital) {
        this.degreeHospital = degreeHospital;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Boolean geteMedical() {
        return eMedical;
    }

    public void seteMedical(Boolean eMedical) {
        this.eMedical = eMedical;
    }

    public Integer getTelemedicineFee() {
        return telemedicineFee;
    }

    public void setTelemedicineFee(Integer telemedicineFee) {
        this.telemedicineFee = telemedicineFee;
    }

    public Integer getInPersionFee() {
        return inPersionFee;
    }

    public void setInPersionFee(Integer inPersionFee) {
        this.inPersionFee = inPersionFee;
    }

    public Integer geteBoardFee() {
        return eBoardFee;
    }

    public void seteBoardFee(Integer eBoardFee) {
        this.eBoardFee = eBoardFee;
    }

    public Boolean getProvideTelemedicine() {
        return provideTelemedicine;
    }

    public void setProvideTelemedicine(Boolean provideTelemedicine) {
        this.provideTelemedicine = provideTelemedicine;
    }

    public Boolean getProvideInPersion() {
        return provideInPersion;
    }

    public void setProvideInPersion(Boolean provideInPersion) {
        this.provideInPersion = provideInPersion;
    }

    public Boolean getProvideLiveDoctor() {
        return provideLiveDoctor;
    }

    public void setProvideLiveDoctor(Boolean provideLiveDoctor) {
        this.provideLiveDoctor = provideLiveDoctor;
    }

    public Integer getLiveDoctorFee() {
        return liveDoctorFee;
    }

    public void setLiveDoctorFee(Integer liveDoctorFee) {
        this.liveDoctorFee = liveDoctorFee;
    }

    public Boolean getExpertForAssessment() {
        return expertForAssessment;
    }

    public void setExpertForAssessment(Boolean expertForAssessment) {
        this.expertForAssessment = expertForAssessment;
    }

    public Integer getMaxFreeFollowupDays() {
        return maxFreeFollowupDays;
    }

    public void setMaxFreeFollowupDays(Integer maxFreeFollowupDays) {
        this.maxFreeFollowupDays = maxFreeFollowupDays;
    }

    public Integer getMaxPatientLimit() {
        return maxPatientLimit;
    }

    public void setMaxPatientLimit(Integer maxPatientLimit) {
        this.maxPatientLimit = maxPatientLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
