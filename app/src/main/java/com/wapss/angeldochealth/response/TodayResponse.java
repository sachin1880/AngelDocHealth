package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TodayResponse {
    @SerializedName("result")
    @Expose
    private List<Result> result;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public class Result {

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
        @SerializedName("prescriptionFile")
        @Expose
        private String prescriptionFile;
        @SerializedName("period")
        @Expose
        private Period period;
        @SerializedName("patientDetail")
        @Expose
        private PatientDetail patientDetail;
        @SerializedName("organization")
        @Expose
        private String organization;
//        @SerializedName("prescription")
//        @Expose
//        private List<Object> prescription;
        @SerializedName("paymentHistory")
        @Expose
        private String paymentHistory;

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

        public String getPrescriptionFile() {
            return prescriptionFile;
        }

        public void setPrescriptionFile(String prescriptionFile) {
            this.prescriptionFile = prescriptionFile;
        }

        public Period getPeriod() {
            return period;
        }

        public void setPeriod(Period period) {
            this.period = period;
        }

        public PatientDetail getPatientDetail() {
            return patientDetail;
        }

        public void setPatientDetail(PatientDetail patientDetail) {
            this.patientDetail = patientDetail;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getPaymentHistory() {
            return paymentHistory;
        }

        public void setPaymentHistory(String paymentHistory) {
            this.paymentHistory = paymentHistory;
        }
    }
    public class Period {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("time_start")
        @Expose
        private String timeStart;
        @SerializedName("time_end")
        @Expose
        private String timeEnd;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("account")
        @Expose
        private Account account;

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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
    }
    public class Account {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fcm_token")
        @Expose
        private String fcmToken;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFcmToken() {
            return fcmToken;
        }

        public void setFcmToken(String fcmToken) {
            this.fcmToken = fcmToken;
        }
    }
}
