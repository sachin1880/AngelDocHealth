package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileResponse {
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
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("followup_days")
    @Expose
    private Integer followupDays;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("verify")
    @Expose
    private Boolean verify;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("updatedBy")
    @Expose
    private String updatedBy;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("doctorLanguage")
    @Expose
    private List<DoctorLanguage> doctorLanguage;
    @SerializedName("doctorSchedule")
    @Expose
    private List<DoctorSchedule> doctorSchedule;

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

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getFollowupDays() {
        return followupDays;
    }

    public void setFollowupDays(Integer followupDays) {
        this.followupDays = followupDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<DoctorLanguage> getDoctorLanguage() {
        return doctorLanguage;
    }

    public void setDoctorLanguage(List<DoctorLanguage> doctorLanguage) {
        this.doctorLanguage = doctorLanguage;
    }

    public List<DoctorSchedule> getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(List<DoctorSchedule> doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }
//    @SerializedName("doctorSpecialization")
//    @Expose
//    private List<Object> doctorSpecialization;

    public class Account {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("whatsapp")
        @Expose
        private Boolean whatsapp;
        @SerializedName("status")
        @Expose
        private String status;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Boolean getWhatsapp() {
            return whatsapp;
        }

        public void setWhatsapp(Boolean whatsapp) {
            this.whatsapp = whatsapp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public class State {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

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
    }

    public class DoctorLanguage {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("isRead")
        @Expose
        private Boolean isRead;
        @SerializedName("isWrite")
        @Expose
        private Boolean isWrite;
        @SerializedName("isSpeak")
        @Expose
        private Boolean isSpeak;
        @SerializedName("languageId")
        @Expose
        private Integer languageId;
        @SerializedName("language")
        @Expose
        private Language language;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getRead() {
            return isRead;
        }

        public void setRead(Boolean read) {
            isRead = read;
        }

        public Boolean getWrite() {
            return isWrite;
        }

        public void setWrite(Boolean write) {
            isWrite = write;
        }

        public Boolean getSpeak() {
            return isSpeak;
        }

        public void setSpeak(Boolean speak) {
            isSpeak = speak;
        }

        public Integer getLanguageId() {
            return languageId;
        }

        public void setLanguageId(Integer languageId) {
            this.languageId = languageId;
        }

        public Language getLanguage() {
            return language;
        }

        public void setLanguage(Language language) {
            this.language = language;
        }
    }

    public class DoctorSchedule {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("mode")
        @Expose
        private String mode;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("leaveStartDate")
        @Expose
        private Object leaveStartDate;
        @SerializedName("leaveEndDate")
        @Expose
        private Object leaveEndDate;
        @SerializedName("period")
        @Expose
        private List<Period> period;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getLeaveStartDate() {
            return leaveStartDate;
        }

        public void setLeaveStartDate(Object leaveStartDate) {
            this.leaveStartDate = leaveStartDate;
        }

        public Object getLeaveEndDate() {
            return leaveEndDate;
        }

        public void setLeaveEndDate(Object leaveEndDate) {
            this.leaveEndDate = leaveEndDate;
        }

        public List<Period> getPeriod() {
            return period;
        }

        public void setPeriod(List<Period> period) {
            this.period = period;
        }
    }

    public class Language {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

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
    }

    public class Period {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("periodStatus")
        @Expose
        private Boolean periodStatus;
        @SerializedName("clinicVisit")
        @Expose
        private Boolean clinicVisit;
        @SerializedName("telemedicine")
        @Expose
        private Boolean telemedicine;
        @SerializedName("no_of_patients")
        @Expose
        private Integer noOfPatients;
        @SerializedName("live_doctor")
        @Expose
        private Boolean liveDoctor;
        @SerializedName("fees")
        @Expose
        private Integer fees;
        @SerializedName("time_start")
        @Expose
        private String timeStart;
        @SerializedName("time_end")
        @Expose
        private String timeEnd;
        @SerializedName("organization")
        @Expose
        private String organization;

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

        public Boolean getPeriodStatus() {
            return periodStatus;
        }

        public void setPeriodStatus(Boolean periodStatus) {
            this.periodStatus = periodStatus;
        }

        public Boolean getClinicVisit() {
            return clinicVisit;
        }

        public void setClinicVisit(Boolean clinicVisit) {
            this.clinicVisit = clinicVisit;
        }

        public Boolean getTelemedicine() {
            return telemedicine;
        }

        public void setTelemedicine(Boolean telemedicine) {
            this.telemedicine = telemedicine;
        }

        public Integer getNoOfPatients() {
            return noOfPatients;
        }

        public void setNoOfPatients(Integer noOfPatients) {
            this.noOfPatients = noOfPatients;
        }

        public Boolean getLiveDoctor() {
            return liveDoctor;
        }

        public void setLiveDoctor(Boolean liveDoctor) {
            this.liveDoctor = liveDoctor;
        }

        public Integer getFees() {
            return fees;
        }

        public void setFees(Integer fees) {
            this.fees = fees;
        }

        public String getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(String timeStart) {
            this.timeStart = timeStart;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }
    }
}
