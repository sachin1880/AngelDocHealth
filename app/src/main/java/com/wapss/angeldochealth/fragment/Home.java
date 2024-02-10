package com.wapss.angeldochealth.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.activity.AppointmentDetails;
import com.wapss.angeldochealth.activity.RegistrationActivity;
import com.wapss.angeldochealth.adapter.Banner_Adapter;
import com.wapss.angeldochealth.adapter.NotificationAdapter;
import com.wapss.angeldochealth.adapter.TodayAppointmentAdapter;
import com.wapss.angeldochealth.apiServices.ApiService;
import com.wapss.angeldochealth.interfaces.ViewTodayAppointmentListener;
import com.wapss.angeldochealth.response.Banner_Response;
import com.wapss.angeldochealth.response.TodayResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    LinearLayout tv_show_Details;
    ViewPager view_pager;
    SharedPreferences loginPref;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    String deviceToken;
    List<Banner_Response.Result> GetBanner;
    List<TodayResponse.Result> todayAppointment;
    private int currentPage = 0;
    private final long DELAY_MS = 5000; // Delay in milliseconds before flipping to the next page
    private final long PERIOD_MS = 5000; // Time period between each auto-flipping
    TodayAppointmentAdapter todayAppointmentAdapter;
    RecyclerView rv_todayAppointment;
    LinearLayout ll_view;
    TextView tv_totalAppointment,tv_date;
    private Calendar calendar;
    ImageView iv_date;
    String dates;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = requireActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(requireActivity().getWindow().getContext(), R.color.black));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home = inflater.inflate(R.layout.fragment_home, container, false);
        view_pager = home.findViewById(R.id.view_pager);
        rv_todayAppointment = home.findViewById(R.id.rv_todayAppointment);
        ll_view = home.findViewById(R.id.ll_view);
        tv_totalAppointment = home.findViewById(R.id.tv_totalAppointment);
        iv_date = home.findViewById(R.id.iv_date);
        tv_date = home.findViewById(R.id.tv_date);

        //shared Pref
        loginPref = getContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        editor = loginPref.edit();
        deviceToken = loginPref.getString("deviceToken", null);
        //loading
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");

        calendar = Calendar.getInstance();
        iv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                tv_date.setText(dateFormat1.format(calendar.getTime()));
                                String datess = tv_date.getText().toString();
                                callTodayAppointmentAPI(datess);
                            }
                        }, year, month, dayOfMonth);
                calendar.set(year, month, dayOfMonth);
//                long value = calendar.getTimeInMillis();
//
//                datePickerDialog.getDatePicker().setMinDate(value);
                datePickerDialog.show();
            }
        });

//        tv_show_Details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), AppointmentDetails.class);
//                startActivity(intent);
//            }
//        });
        dates = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        getBanner();
        callTodayAppointmentAPI(dates);
        return home;
    }

    private void callTodayAppointmentAPI(String dates) {
        progressDialog.show();
        String Token = "Bearer " + deviceToken;
        Call<TodayResponse> get_banner_api = ApiService.apiHolders().getTodayAppointment(Token, "50", "0", "", "Pending",dates);
        get_banner_api.enqueue(new Callback<TodayResponse>() {
            @Override
            public void onResponse(Call<TodayResponse> call, Response<TodayResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    assert response.body() != null;
                    int total = response.body().getTotal();
                    if (total == 0) {
                        ll_view.setVisibility(View.VISIBLE);
                        rv_todayAppointment.setVisibility(View.GONE);
                    }
                        ll_view.setVisibility(View.GONE);
                        todayAppointment = response.body().getResult();
                        int totals = response.body().getTotal();
                        String tt = String.valueOf(totals);
                        tv_totalAppointment.setText("Total Appointment :" + tt);
                        todayAppointmentAdapter = new TodayAppointmentAdapter(getContext(), todayAppointment, new ViewTodayAppointmentListener() {
                            @Override
                            public void onItemClickedItem(TodayResponse.Result item, int position) {

                            }
                        });
                        rv_todayAppointment.setAdapter(todayAppointmentAdapter);
                        rv_todayAppointment.setLayoutManager(new LinearLayoutManager(getContext()));

                } else {
                    progressDialog.hide();
                    rv_todayAppointment.setVisibility(View.GONE);
                    ll_view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<TodayResponse> call, Throwable t) {
                progressDialog.hide();
                rv_todayAppointment.setVisibility(View.GONE);
                ll_view.setVisibility(View.VISIBLE);
            }
        });
    }

    private void getBanner() {
        progressDialog.show();
        // String token = deviceToken;
        String type = "Doctor";
        Call<Banner_Response> get_banner_api = ApiService.apiHolders().getBanner(type);
        get_banner_api.enqueue(new Callback<Banner_Response>() {
            @Override
            public void onResponse(Call<Banner_Response> call, Response<Banner_Response> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    assert response.body() != null;
                    GetBanner = response.body().getResult();
                    Banner_Adapter bannerAdapter = new Banner_Adapter(getContext(), GetBanner);
                    view_pager.setAdapter(bannerAdapter);
                    final Handler handler = new Handler(Looper.getMainLooper());
                    final Runnable update = () -> {
                        if (currentPage == GetBanner.size()) {
                            currentPage = 0;
                        }
                        view_pager.setCurrentItem(currentPage++, true);
                    };
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(update);
                        }
                    }, DELAY_MS, PERIOD_MS);
                } else {
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(Call<Banner_Response> call, Throwable t) {
                progressDialog.hide();
            }
        });
    }
}