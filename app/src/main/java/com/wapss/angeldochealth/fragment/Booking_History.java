package com.wapss.angeldochealth.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.activity.AppointmentDetails;

public class Booking_History extends Fragment {
    LinearLayout tv_show_Details;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View report = inflater.inflate(R.layout.fragment_booking__history, container, false);
        tv_show_Details = report.findViewById(R.id.tv_show_Details);

        tv_show_Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AppointmentDetails.class);
                startActivity(intent);
            }
        });

        return report;
    }
}