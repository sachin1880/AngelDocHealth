package com.wapss.angeldochealth.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.adapter.TodayAppointmentAdapter;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.interfaces.ViewTodayAppointmentListener;
import com.wapss.angeldochealth.response.ConfirmAppointmentData;
import com.wapss.angeldochealth.response.ConfirmAppointmnetResponse;
import com.wapss.angeldochealth.response.TodayResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentDetails extends AppCompatActivity {
    TextView btn_confirm,btn_cancel;
    int id;
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    String deviceToken;
    TextView tv_bookingId,txt_name,txt_address,tv_gender,tv_doB,tv_bookingDate,tv_time,doc_fee,totalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        tv_bookingId= findViewById(R.id.tv_bookingId);
        txt_name = findViewById(R.id.txt_name);
        txt_address= findViewById(R.id.txt_address);
        tv_gender = findViewById(R.id.tv_gender);
        tv_doB= findViewById(R.id.tv_doB);
        tv_bookingDate = findViewById(R.id.tv_bookingDate);
        tv_time= findViewById(R.id.tv_time);
        doc_fee = findViewById(R.id.doc_fee);
        totalValue = findViewById(R.id.totalValue);

        //shared Pref
        loginPref = getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
        deviceToken = loginPref.getString("deviceToken", null);
        //loading
        progressDialog = new ProgressDialog(AppointmentDetails.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");

        btn_confirm= findViewById(R.id.btn_login1);
        btn_cancel = findViewById(R.id.btn_cancel);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        // getting the string back
        {
            id = bundle.getInt("id", 0);
        }

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAcceptApi("Accepted");
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAcceptApi("Cancelled");
            }
        });

        callAppointmnetDetails(id);
    }

    private void callAcceptApi(String accepted) {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<ConfirmAppointmentData> get_banner_api = ApiService.apiHolders().AcceptAppointment(Token,id,accepted);
        get_banner_api.enqueue(new Callback<ConfirmAppointmentData>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ConfirmAppointmentData> call, Response<ConfirmAppointmentData> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    assert response.body() != null;
                    if (Objects.equals(accepted, "Accepted")){
                        Intent intent = new Intent(AppointmentDetails.this,ConfirmBookingActivity.class);
                        startActivity(intent);
                    }
                    else if (Objects.equals(accepted, "Cancelled")){
                        Intent intent = new Intent(AppointmentDetails.this,RejectAppointmentActivity.class);
                        startActivity(intent);
                    }
                } else {
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(Call<ConfirmAppointmentData> call, Throwable t) {
                progressDialog.hide();
            }
        });
    }

    private void callAppointmnetDetails(int id) {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<ConfirmAppointmnetResponse> get_banner_api = ApiService.apiHolders().get_AppointmentDetails(Token,id);
        get_banner_api.enqueue(new Callback<ConfirmAppointmnetResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ConfirmAppointmnetResponse> call, Response<ConfirmAppointmnetResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    assert response.body() != null;
                    int bookingId =response.body().getId();
                    String bId= String.valueOf(bookingId);
                    tv_bookingId.setText("Booking Id : " + bId);
                    txt_name.setText(response.body().getPatientDetail().getName());
                    txt_address.setText(response.body().getPatientDetail().getCity());
                    tv_gender.setText(response.body().getPatientDetail().getGender());
                    tv_doB.setText(response.body().getPatientDetail().getDob());
                    tv_bookingDate.setText(response.body().getBookingDate());
                    int fee = response.body().getDoctorDetail().getFee();
                    String feess= String.valueOf(fee);
                    doc_fee.setText("₹" + " " + feess);
                    totalValue.setText("₹" + " " + response.body().getDoctorDetail().getFee());
                } else {
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(Call<ConfirmAppointmnetResponse> call, Throwable t) {
                progressDialog.hide();
            }
        });

    }
}