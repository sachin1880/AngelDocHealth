package com.wapss.angeldochealth.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

public class Profile extends Fragment {
    ImageView iv_verified;
    LinearLayout ll_logOut;
    private Dialog noInternetDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profile = inflater.inflate(R.layout.fragment_profile, container, false);
        iv_verified= profile.findViewById(R.id.iv_verified);
        ll_logOut = profile.findViewById(R.id.ll_logOut);

        iv_verified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VerifiedDoctorActivity.class);
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

        return profile;
    }
}