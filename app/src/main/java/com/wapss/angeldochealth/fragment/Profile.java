package com.wapss.angeldochealth.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.activity.LoginActivity;
import com.wapss.angeldochealth.activity.VerifiedDoctorActivity;
import com.wapss.angeldochealth.adapter.TodayAppointmentAdapter;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.interfaces.ViewTodayAppointmentListener;
import com.wapss.angeldochealth.response.ProfileResponse;
import com.wapss.angeldochealth.response.TodayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends Fragment {
    ImageView iv_verified;
    LinearLayout ll_logOut;
    private Dialog noInternetDialog;
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    String deviceToken;
    TextView txt_name,txt_email;
    ImageView iv_profile;
    int doc_Id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profile = inflater.inflate(R.layout.fragment_profile, container, false);
        iv_profile = profile.findViewById(R.id.iv_profile);
        txt_name = profile.findViewById(R.id.txt_name);
        txt_email = profile.findViewById(R.id.txt_email);
        iv_verified= profile.findViewById(R.id.iv_verified);
        ll_logOut = profile.findViewById(R.id.ll_logOut);
        loginPref = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
        deviceToken = loginPref.getString("deviceToken", null);
        //loading
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");

        iv_verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("doc_Id",doc_Id);
                Intent intent = new Intent(getContext(), VerifiedDoctorActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ll_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noInternetDialog = new Dialog(getContext());
                noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                noInternetDialog.setContentView(R.layout.logout_layout1);
                noInternetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                noInternetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                noInternetDialog.show();
                TextView et_yes = (TextView)noInternetDialog.findViewById(R.id.et_yes);
                TextView et_cancel = (TextView)noInternetDialog.findViewById(R.id.et_cancel);
                et_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences preferences = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.apply();
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
                et_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        noInternetDialog.dismiss();
                    }
                });
                noInternetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                noInternetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            }
        });

        callProfileAPI();

        return profile;
    }

    private void callProfileAPI() {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<ProfileResponse> get_banner_api = ApiService.apiHolders().get_profile(Token);
        get_banner_api.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    assert response.body() != null;
                    txt_name.setText(response.body().getName());
                    txt_email.setText(response.body().getEmail());
                    Boolean verified=response.body().getVerify();
                    doc_Id = response.body().getId();
                    if (verified){
                        iv_verified.setVisibility(View.GONE);
                    }else {
                        iv_verified.setVisibility(View.VISIBLE);
                    }

                } else {
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                progressDialog.hide();
            }
        });
    }
}