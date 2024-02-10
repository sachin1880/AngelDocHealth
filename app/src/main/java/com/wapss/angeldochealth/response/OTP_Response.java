package com.wapss.angeldochealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTP_Response {
    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {

        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("latest")
        @Expose
        private Boolean latest;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Boolean getLatest() {
            return latest;
        }

        public void setLatest(Boolean latest) {
            this.latest = latest;
        }
    }

}
