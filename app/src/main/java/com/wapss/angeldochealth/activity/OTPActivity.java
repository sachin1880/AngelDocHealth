package com.wapss.angeldochealth.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.response.OTP_Response;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {
    TextView btn_Otp_submit,count_time;
    EditText otp1,otp2,otp3,otp4,otp5,otp6;
    String latest,otp,phone;
    ProgressDialog progressDialog;
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ImageView otp_back;
    private CountDownTimer countDownTimer;
    long timerDuration = 60000;
    long timerInterval = 1000;
    TextView btn_resend;
    LinearLayout tv_verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        initi();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        if (bundle != null) {
            //latest = bundle.getString("latest");
        }

        otp_move();
        btn_Otp_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp = otp1.getText().toString()+otp2.getText().toString()+otp3.getText().toString()+otp4.getText().toString()+otp5.getText().toString()+otp6.getText().toString();

                if (otp1.getText().toString().isEmpty() || otp2.getText().toString().isEmpty() || otp3.getText().toString().isEmpty() ||
                        otp4.getText().toString().isEmpty()){
                    Toast.makeText(OTPActivity.this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }
                else {
                    callVerifyOTP(otp,phone);
                }
            }
        });

        btn_resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp = otp1.getText().toString()+otp2.getText().toString()+otp3.getText().toString()+otp4.getText().toString()+otp5.getText().toString()+otp6.getText().toString();

                if (otp1.getText().toString().isEmpty() || otp2.getText().toString().isEmpty() || otp3.getText().toString().isEmpty() ||
                        otp4.getText().toString().isEmpty()){
                    Toast.makeText(OTPActivity.this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }
                else {
                    callVerifyOTP(otp,phone);
                }
            }
        });

        otp_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        CountDown();
    }
    private void CountDown() {
        countDownTimer = new CountDownTimer(timerDuration, timerInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timerTextView with the remaining time
                count_time.setText( millisUntilFinished / 1000 + " Sec");
                btn_resend.setVisibility(View.GONE);
                tv_verify.setVisibility(View.VISIBLE);
            }
            @Override
            public void onFinish() {
                // Timer finished, you can perform actions here
                btn_resend.setVisibility(View.VISIBLE);
                count_time.setVisibility(View.GONE);
                tv_verify.setVisibility(View.GONE);
                otp1.setText("");
                otp2.setText("");
                otp3.setText("");
                otp4.setText("");
                otp5.setText("");
                otp6.setText("");
            }
        };
        // Start the timer
        countDownTimer.start();
    }

    private void callVerifyOTP(String otp, String phone) {
        progressDialog.show();
        Call<OTP_Response> login_apiCall = ApiService.apiHolders().OTP_Verify(otp,phone);
        login_apiCall.enqueue(new Callback<OTP_Response>() {
            @Override
            public void onResponse(Call<OTP_Response> call, Response<OTP_Response> response) {
                if (response.code() == 401){
                    invalidOTP();
                    progressDialog.hide();
                }
                else {
                    if(response.code() == 201) {
                        assert response.body() != null;
                        String deviceToken = response.body().getResult().getToken();
                        Boolean latest = response.body().getResult().getLatest();
                        String latests = String.valueOf(latest);
                        editor.putString("deviceToken", deviceToken);
                        editor.commit();
                        final androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(OTPActivity.this);
                        LayoutInflater inflater1 = getLayoutInflater();
                        View dialogView1 = inflater1.inflate(R.layout.otp_success_layout,null);
                        builder1.setCancelable(false);
                        builder1.setView(dialogView1);
                        final androidx.appcompat.app.AlertDialog alertDialog1 = builder1.create();
                        alertDialog1.show();
                        alertDialog1.setCanceledOnTouchOutside(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Toast.makeText(OTPActivity.this, ""+latestLogin, Toast.LENGTH_SHORT).show();
                                Intent intent;
                                if (Objects.equals(latests, "true")) {
                                    Intent intent1 = new Intent(OTPActivity.this,RegistrationActivity.class);
                                    startActivity(intent1);
                                }else {
                                    intent = new Intent(OTPActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                                alertDialog1.dismiss();
                            }
                        },2000);
                        progressDialog.hide();

                    } else {
                        progressDialog.hide();
                        //progressDialog.hideProgressDialog();
                    }
                }
            }
            @Override
            public void onFailure(Call<OTP_Response> call, Throwable t) {
                progressDialog.hide();
                //progressDialog.hideProgressDialog();

            }
        });
        }

    private void invalidOTP() {
        final androidx.appcompat.app.AlertDialog.Builder builder1 = new androidx.appcompat.app.AlertDialog.Builder(OTPActivity.this);
        LayoutInflater inflater1 = getLayoutInflater();
        View dialogView1 = inflater1.inflate(R.layout.invalidotp_layout,null);
        builder1.setCancelable(false);
        builder1.setView(dialogView1);
        final androidx.appcompat.app.AlertDialog alertDialog1 = builder1.create();
        alertDialog1.show();
        alertDialog1.setCanceledOnTouchOutside(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog1.dismiss();
                otp1.setText("");
                otp2.setText("");
                otp3.setText("");
                otp4.setText("");
                otp5.setText("");
                otp6.setText("");
            }
        },5000);
    }

    private void initi() {
        tv_verify = findViewById(R.id.tv_verify);
        btn_resend = findViewById(R.id.btn_resend);
        otp_back = findViewById(R.id.otp_back);
        count_time= findViewById(R.id.count_time);
        btn_Otp_submit= findViewById(R.id.btn_Otp_submit);
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp5 = findViewById(R.id.otp5);
        otp6 = findViewById(R.id.otp6);
        //loading
        progressDialog = new ProgressDialog(OTPActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        //sharedPrefrence
        loginPref = getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        phone = loginPref.getString("phone", null);
        editor = loginPref.edit();
    }

    private void otp_move() {
        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // otp1.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
               // otp1.setTextColor(getResources().getColor(R.color.white));
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (otp1.getText().toString().length() == 1) {
                    otp1.clearFocus();
                    otp2.requestFocus();
                    otp2.setCursorVisible(true);
                } else {
                    otp1.requestFocus();
                    //otp1.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                    //otp1.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // otp2.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
               // otp2.setTextColor(getResources().getColor(R.color.white));

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp2.getText().toString().length() == 1) {
                    otp2.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                } else {
                    otp2.clearFocus();
                    otp1.requestFocus();
                    otp1.setCursorVisible(true);
                  //  otp2.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                }
            }
        });
        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // otp3.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
               // otp3.setTextColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp3.getText().toString().length() == 1) {
                    otp3.clearFocus();
                    otp4.requestFocus();
                    otp4.setCursorVisible(true);
                } else {
                    otp3.clearFocus();
                    otp2.requestFocus();
                    otp2.setCursorVisible(true);
                   // otp3.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                }
            }
        });
        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
               // otp4.setTextColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (otp4.getText().toString().length() == 1) {
                    otp4.clearFocus();
                    otp5.requestFocus();
                    otp5.setCursorVisible(true);
                    // otp5.setCursorVisible(true);
                } else {
                    otp4.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                   // otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                }
            }
        });
        otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
                // otp4.setTextColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (otp5.getText().toString().length() == 1) {
                    otp5.clearFocus();
                    otp6.requestFocus();
                    otp6.setCursorVisible(true);
                    // otp5.setCursorVisible(true);
                } else {
                    otp5.clearFocus();
                    otp4.requestFocus();
                    otp4.setCursorVisible(true);
                    // otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                }
            }
        });

        otp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.otp_bg));
                // otp4.setTextColor(getResources().getColor(R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (otp6.getText().toString().length() == 1) {
                    otp6.clearFocus();
                    otp6.requestFocus();
                   // otp5.setCursorVisible(true);
                } else {
                    otp6.clearFocus();
                    otp5.requestFocus();
                    otp5.setCursorVisible(true);
                    // otp4.setBackgroundDrawable(getResources().getDrawable(R.drawable.time_bg));
                }
            }
        });
    }
}