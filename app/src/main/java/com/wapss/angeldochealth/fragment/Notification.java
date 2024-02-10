package com.wapss.angeldochealth.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.adapter.NotificationAdapter;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.response.NotificationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notification extends Fragment {
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    String deviceToken;
    NotificationAdapter notificationAdapter;
    RecyclerView rv_notification;
    List<NotificationResponse.Result> notification;
    LinearLayout ll_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View notification = inflater.inflate(R.layout.fragment_notification, container, false);
        //shared Pref
        loginPref = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
        deviceToken = loginPref.getString("deviceToken", null);
        //loading
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        rv_notification = notification.findViewById(R.id.rv_notification);
        ll_view = notification.findViewById(R.id.ll_view);

        get_Notification();

        return notification;
    }
    private void get_Notification() {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<NotificationResponse> banner_apiCall = ApiService.apiHolders().get_notification(Token);
        banner_apiCall.enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    assert response.body() != null;
                    int total = response.body().getTotal();
                    if (total == 0) {
                        //iv_noti.setVisibility(View.VISIBLE);
                        ll_view.setVisibility(View.VISIBLE);
                    }
                    notification = response.body().getResult();
                    notificationAdapter = new NotificationAdapter(getContext(), notification);
                    rv_notification.setAdapter(notificationAdapter);
                    rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));

                } else {
                    progressDialog.dismiss();
                    //iv_noti.setVisibility(View.VISIBLE);
                    ll_view.setVisibility(View.VISIBLE);
                    //Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable t) {
                progressDialog.dismiss();
                //iv_noti.setVisibility(View.VISIBLE);
                ll_view.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}