package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfirmAppointmnetResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("bookingDate")
    @Expose
    private String bookingDate;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("patientType")
    @Expose
    private String patientType;
    @SerializedName("followUpType")
    @Expose
    private String followUpType;
    @SerializedName("callStatus")
    @Expose
    private String callStatus;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("audioName")
    @Expose
    private String audioName;
    @SerializedName("prescriptionFile")
    @Expose
    private String prescriptionFile;
    @SerializedName("prescriptionFileName")
    @Expose
    private String prescriptionFileName;
    @SerializedName("rescheduleCount")
    @Expose
    private Integer rescheduleCount;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("updatedBy")
    @Expose
    private String updatedBy;
    @SerializedName("patientDetailId")
    @Expose
    private Integer patientDetailId;
    @SerializedName("organizationId")
    @Expose
    private String organizationId;
    @SerializedName("periodId")
    @Expose
    private Integer periodId;
    @SerializedName("doctorDetailId")
    @Expose
    private Integer doctorDetailId;
    @SerializedName("paymentHistoryId")
    @Expose
    private String paymentHistoryId;
    @SerializedName("userSubscriptionId")
    @Expose
    private String userSubscriptionId;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("paymentHistory")
    @Expose
    private String paymentHistory;
    @SerializedName("patientDetail")
    @Expose
    private PatientDetail patientDetail;
    @SerializedName("period")
    @Expose
    private Period period;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("doctorDetail")
    @Expose
    private DoctorDetail doctorDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(String followUpType) {
        this.followUpType = followUpType;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getPrescriptionFile() {
        return prescriptionFile;
    }

    public void setPrescriptionFile(String prescriptionFile) {
        this.prescriptionFile = prescriptionFile;
    }

    public String getPrescriptionFileName() {
        return prescriptionFileName;
    }

    public void setPrescriptionFileName(String prescriptionFileName) {
        this.prescriptionFileName = prescriptionFileName;
    }

    public Integer getRescheduleCount() {
        return rescheduleCount;
    }

    public void setRescheduleCount(Integer rescheduleCount) {
        this.rescheduleCount = rescheduleCount;
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

    public Integer getPatientDetailId() {
        return patientDetailId;
    }

    public void setPatientDetailId(Integer patientDetailId) {
        this.patientDetailId = patientDetailId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Integer getDoctorDetailId() {
        return doctorDetailId;
    }

    public void setDoctorDetailId(Integer doctorDetailId) {
        this.doctorDetailId = doctorDetailId;
    }

    public String getPaymentHistoryId() {
        return paymentHistoryId;
    }

    public void setPaymentHistoryId(String paymentHistoryId) {
        this.paymentHistoryId = paymentHistoryId;
    }

    public String getUserSubscriptionId() {
        return userSubscriptionId;
    }

    public void setUserSubscriptionId(String userSubscriptionId) {
        this.userSubscriptionId = userSubscriptionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(String paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public PatientDetail getPatientDetail() {
        return patientDetail;
    }

    public void setPatientDetail(PatientDetail patientDetail) {
        this.patientDetail = patientDetail;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public DoctorDetail getDoctorDetail() {
        return doctorDetail;
    }

    public void setDoctorDetail(DoctorDetail doctorDetail) {
        this.doctorDetail = doctorDetail;
    }

    public class Account {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("designation")
        @Expose
        private String designation;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("fcm_token")
        @Expose
        private String fcmToken;
        @SerializedName("session_id")
        @Expose
        private String sessionId;
        @SerializedName("whatsapp")
        @Expose
        private Boolean whatsapp;
        @SerializedName("tnc")
        @Expose
        private Boolean tnc;
        @SerializedName("createdBy")
        @Expose
        private String createdBy;
        @SerializedName("updatedBy")
        @Expose
        private String updatedBy;
        @SerializedName("roles")
        @Expose
        private String roles;
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

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFcmToken() {
            return fcmToken;
        }

        public void setFcmToken(String fcmToken) {
            this.fcmToken = fcmToken;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public Boolean getWhatsapp() {
            return whatsapp;
        }

        public void setWhatsapp(Boolean whatsapp) {
            this.whatsapp = whatsapp;
        }

        public Boolean getTnc() {
            return tnc;
        }

        public void setTnc(Boolean tnc) {
            this.tnc = tnc;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
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

    public class PatientDetail {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("dob")
        @Expose
        private String dob;
        @SerializedName("blood_group")
        @Expose
        private String bloodGroup;
        @SerializedName("relationship")
        @Expose
        private String relationship;
        @SerializedName("profile")
        @Expose
        private String profile;
        @SerializedName("profileName")
        @Expose
        private String profileName;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("accountId")
        @Expose
        private Integer accountId;
        @SerializedName("updatedBy")
        @Expose
        private String updatedBy;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getBloodGroup() {
            return bloodGroup;
        }

        public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public String getRelationship() {
            return relationship;
        }

        public void setRelationship(String relationship) {
            this.relationship = relationship;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
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
        @SerializedName("time_start")
        @Expose
        private String timeStart;
        @SerializedName("time_end")
        @Expose
        private String timeEnd;
        @SerializedName("doctorScheduleId")
        @Expose
        private Integer doctorScheduleId;

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

        public Integer getDoctorScheduleId() {
            return doctorScheduleId;
        }

        public void setDoctorScheduleId(Integer doctorScheduleId) {
            this.doctorScheduleId = doctorScheduleId;
        }
//        @SerializedName("doctorSchedule")
//        @Expose
//        private DoctorSchedule doctorSchedule;
    }

    public class DoctorDetail {

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
}
