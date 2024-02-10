package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfirmAppointmentData {
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
    private Integer updatedBy;
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

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
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
}
