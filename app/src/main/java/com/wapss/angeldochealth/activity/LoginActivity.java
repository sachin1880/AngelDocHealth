package com.wapss.angeldochealth.activity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.response.LoginResponse;
import com.wapss.angeldochealth.utility.DeviceUtils;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView btn_login;
    EditText et_phone;
    ProgressDialog progressDialog;
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    CheckBox checkBoxTerms;
    Boolean cb_term = false;
    String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initi();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));
        /*Device Id Get*/
        deviceId = DeviceUtils.getDeviceId(getApplicationContext());

        checkBoxTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cb_term = true;
                } else {
                    cb_term = false;
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et_phone.getText().toString();
                if (validation()) {
                    callAPI(phone);
                }
            }
        });
    }

    private boolean validation() {
        if (et_phone.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!cb_term) {
            Toast.makeText(this, "Please Check Terms And Conditions", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void callAPI(String phone) {
        progressDialog.show();
        Call<LoginResponse> login_apiCall = ApiService.apiHolders().login(phone,true,true,deviceId);
        login_apiCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 201) {
                    LoginResponse userLogin_response = response.body();
                    assert response.body() != null;
                    assert userLogin_response != null;
                    Boolean latest = userLogin_response.getLatest();
                    String latests= String.valueOf(latest);
                    editor.putString("phone", phone);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("latest",latests);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, OTPActivity.class);
                    //intent.putExtras(bundle);
                    startActivity(intent);
                    progressDialog.hide();

                } else {
                    progressDialog.hide();
                     Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initi() {
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        btn_login = findViewById(R.id.btn_login);
        et_phone = findViewById(R.id.et_phone);
        //loading
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        //sharedPrefrence
        loginPref = getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
    }
}