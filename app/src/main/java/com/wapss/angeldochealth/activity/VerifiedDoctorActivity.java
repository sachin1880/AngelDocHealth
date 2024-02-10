package com.wapss.angeldochealth.activity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.wapss.angeldochealth.R;

public class VerifiedDoctorActivity extends AppCompatActivity {
    TextView btn_greenCard;
    private Dialog noInternetDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified_doctor);
        btn_greenCard = findViewById(R.id.btn_greenCard);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        btn_greenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // popUp();
                noInternetDialog = new Dialog(VerifiedDoctorActivity.this);
                noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                noInternetDialog.setContentView(R.layout.logout_layout);
                noInternetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                noInternetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                noInternetDialog.show();
                TextView et_yes = (TextView) noInternetDialog.findViewById(R.id.et_yes);
                TextView et_cancel = (TextView) noInternetDialog.findViewById(R.id.et_cancel);
                et_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VerifiedDoctorActivity.this, AfterVerifiedDoctorActivity.class);
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

//                new AlertDialog.Builder(VerifiedDoctorActivity.this)
//                        .setTitle("Are You Sure ?")
//                        .setMessage("You will be charge for the verification batch mark of rupees ₹ 999.00. Please confirm Yes.")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent(VerifiedDoctorActivity.this,AfterVerifiedDoctorActivity.class);
//                                startActivity(intent);
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // If the user chooses not to log out, simply dismiss the dialog
//                                dialog.dismiss();
//                            }
//                        })
//                        .show();
            }
        });
    }

    private void popUp() {
//        noInternetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        noInternetDialog.setContentView(R.layout.logout_layout);
//        noInternetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        noInternetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        noInternetDialog.show();
//        TextView et_yes = (TextView)noInternetDialog.findViewById(R.id.et_yes);
//        TextView et_cancel = (TextView)noInternetDialog.findViewById(R.id.et_cancel);
//        et_yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
////                startActivity(intent);
//            }
//        });
//        et_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                noInternetDialog.dismiss();
//            }
//        });
//        noInternetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//        noInternetDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }
}