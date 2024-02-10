package com.wapss.angeldochealth.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.response.LoginResponse;
import com.wapss.angeldochealth.response.RegistrationResponse;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText et_name, et_mail, et_mobile, et_DOB, et_registration, et_registration_year, et_counsil_number, et_registrartionType, et_experience, et_address, et_state;
    RadioGroup rg_gneder;
    RadioButton rb_male, rb_female, rb_other;
    ImageView iv_date;
    Spinner sp_selectType, sp_selectState;
    TextView tv_registration;
    String gender, stateID = "1", deviceToken;
    private Calendar calendar;
    List<String> items = Arrays.asList("Select Registration Type", "State", "Country");
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //shared Pref
        loginPref = getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
        deviceToken = loginPref.getString("deviceToken", null);
        //loading
        progressDialog = new ProgressDialog(RegistrationActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");

        et_name = findViewById(R.id.et_name);
        et_mail = findViewById(R.id.et_mail);
        et_mobile = findViewById(R.id.et_mobile);
        et_DOB = findViewById(R.id.et_DOB);
        et_registration = findViewById(R.id.et_registration);
        et_registration_year = findViewById(R.id.et_registration_year);
        et_counsil_number = findViewById(R.id.et_counsil_number);
        et_registrartionType = findViewById(R.id.et_registrartionType);
        et_experience = findViewById(R.id.et_experience);
        et_address = findViewById(R.id.et_address);
        et_state = findViewById(R.id.et_state);
        tv_registration = findViewById(R.id.tv_registration);
        sp_selectType = findViewById(R.id.sp_selectType);
        sp_selectState = findViewById(R.id.sp_selectState);
        iv_date = findViewById(R.id.iv_date);
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);
        rb_other = findViewById(R.id.rb_other);
        rg_gneder = findViewById(R.id.rg_gneder);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        /*Gender Choose*/
        rg_gneder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle RadioButton selection changes here
                if (rb_male.isChecked()) {
                    gender = "Male";
                } else if (rb_female.isChecked()) {
                    gender = "Female";
                } else if (rb_other.isChecked()) {
                    gender = "Other";
                }
            }
        });

        //DOB
        calendar = Calendar.getInstance();
        iv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegistrationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                et_DOB.setText(dateFormat1.format(calendar.getTime()));
                            }
                        }, year, month, dayOfMonth);
                calendar.set(year, month, dayOfMonth);
                long value = calendar.getTimeInMillis();

                datePickerDialog.getDatePicker().setMaxDate(value);
                datePickerDialog.show();
            }
        });

        /*Study Year*/
        ArrayAdapter<String> study_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        study_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_selectType.setAdapter(study_adapter);
        sp_selectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {

                } else {
                    String RegistrationType = items.get(i);
                    et_registrartionType.setText(RegistrationType);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tv_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String email = et_mail.getText().toString();
                String mobile = et_mobile.getText().toString();
                String Dob = et_DOB.getText().toString();
                String registrationNumber = et_registration.getText().toString();
                String registrationYear = et_registration_year.getText().toString();
                String council_number = et_counsil_number.getText().toString();
                String registrationType = et_registrartionType.getText().toString();
                String experience = et_experience.getText().toString();
                String address = et_address.getText().toString();

                callRegistrationAPI(name, email, mobile, Dob, registrationNumber, registrationYear, council_number, registrationType, experience, address, stateID);
            }
        });
    }

    private void callRegistrationAPI(String name, String email, String mobile, String dob, String registrationNumber, String registrationYear, String councilNumber, String registrationType, String experience, String address, String stateID) {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<RegistrationResponse> login_apiCall = ApiService.apiHolders().RegistrationDoctor(Token, name, email, mobile, gender, dob, registrationNumber, registrationYear, councilNumber, registrationType, address, stateID, experience);
        login_apiCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}