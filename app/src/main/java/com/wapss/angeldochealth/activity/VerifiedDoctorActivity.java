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
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.wapss.angeldochealth.R;

import org.json.JSONException;
import org.json.JSONObject;

public class VerifiedDoctorActivity extends AppCompatActivity implements PaymentResultListener {
    TextView btn_greenCard;
    private Dialog noInternetDialog;
    int doc_Id;
    TextView tv_fee;
    String transId,status_code="400";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified_doctor);
        btn_greenCard = findViewById(R.id.btn_greenCard);
        tv_fee = findViewById(R.id.tv_fee);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        // getting the string back
        {
            doc_Id = bundle.getInt("doc_Id", 0);
        }

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
//                        String fee = tv_fee.getText().toString();
//                        int fees = Integer.parseInt(fee);
                        callRazorPay(1);
//                        Intent intent = new Intent(VerifiedDoctorActivity.this, AfterVerifiedDoctorActivity.class);
//                        startActivity(intent);
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

    private void callRazorPay(int fee) {
        Checkout checkout = new Checkout();
       // checkout.setKeyID("rzp_live_GbnM6KdaZa4TXm");
        checkout.setKeyID("rzp_test_di1mCyXNrjjxsV");
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","Angel Doctor Health");
            jsonObject.put("description","ONLINE PAYMENT");
            jsonObject.put("prefill.email", "moni@gmail.com");
            jsonObject.put("prefill.contact","9330603948");
            jsonObject.put("image","R.drawable.logo");
            jsonObject.put("color","#3399cc");
            jsonObject.put("currency","INR");
            jsonObject.put("amount", fee*100);
            jsonObject.put("orderId","orderId");

            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled",true);
            retryObj.put("max_count", 4);

            jsonObject.put("retry", retryObj);
            checkout.open(VerifiedDoctorActivity.this, jsonObject);

        } catch(Exception e) {
            Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        transId = s;
//        pay_NZ6AcgFtSvybMu  TransId
       // add_history();
        //cart_models.clear();
        //my_cart_adapter.notifyDataSetChanged();
        Toast.makeText(VerifiedDoctorActivity.this, "Payment Successfully!"+s,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPaymentError(int i, String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            String response = String.valueOf(jsonObject.getJSONObject("error").getJSONObject("http_status_code"));
            if (response.equals(status_code)){
                Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}