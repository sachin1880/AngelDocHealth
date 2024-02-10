package com.wapss.angeldochealth.apiServices;

import com.wapss.angeldochealth.response.Banner_Response;
import com.wapss.angeldochealth.response.ConfirmAppointmentData;
import com.wapss.angeldochealth.response.ConfirmAppointmnetResponse;
import com.wapss.angeldochealth.response.LoginResponse;
import com.wapss.angeldochealth.response.NotificationResponse;
import com.wapss.angeldochealth.response.OTP_Response;
import com.wapss.angeldochealth.response.ProfileResponse;
import com.wapss.angeldochealth.response.RegistrationResponse;
import com.wapss.angeldochealth.response.TodayResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiHolder {
    @POST("auth/mobile/dlogin")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("loginId") String phone,
                              @Field("whatsapp") Boolean whatsapp,
                              @Field("tnc") Boolean tnc,
                              @Field("deviceId") String deviceId);

    @POST("auth/verify")
    @FormUrlEncoded
    Call<OTP_Response> OTP_Verify(@Field("otp") String otp,
                                  @Field("loginId") String loginId);

    @PUT("doctor-details/doctor/step1")
    @FormUrlEncoded
    Call<RegistrationResponse> RegistrationDoctor(@Header("Authorization") String Token,
                                                  @Field("name") String name,
                                                  @Field("email") String email,
                                                  @Field("mobile") String mobile,
                                                  @Field("gender") String gender,
                                                  @Field("dob") String dob,
                                                  @Field("reg_number") String reg_number,
                                                  @Field("reg_year") String reg_year,
                                                  @Field("council_number") String council_number,
                                                  @Field("reg_type") String reg_type,
                                                  @Field("address") String address,
                                                  @Field("stateId") String stateId,
                                                  @Field("experience") String experience);

    @GET("banners/all")
    Call<Banner_Response> getBanner(@Query("type") String type);

    @GET("consultation-booking")
    Call<TodayResponse> getTodayAppointment(@Header("Authorization") String Token,
                                            @Query("limit") String limit,
                                            @Query("offset") String offset,
                                            @Query("keyword") String keyword,
                                            @Query("status") String status,
                                            @Query("currentDate") String currentDate);

    @GET("notification")
    Call<NotificationResponse> get_notification(@Header("Authorization") String Token);

    @GET("doctor-details/profile")
    Call<ProfileResponse> get_profile(@Header("Authorization") String Token);

    @GET("consultation-booking/detail/{id}")
    Call<ConfirmAppointmnetResponse> get_AppointmentDetails(@Header("Authorization") String Token,
                                                            @Path("id")int id);

    @PATCH("consultation-booking/booking-status/{id}")
    Call<ConfirmAppointmentData> AcceptAppointment(@Header("Authorization") String Token,
                                                   @Path("id")int id,
                                                   @Field("status")String status);
}
