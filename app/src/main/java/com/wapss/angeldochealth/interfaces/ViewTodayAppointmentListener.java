package com.wapss.angeldochealth.interfaces;

import com.wapss.angeldochealth.response.Banner_Response;
import com.wapss.angeldochealth.response.TodayResponse;

public interface ViewTodayAppointmentListener {
    void onItemClickedItem(TodayResponse.Result item, int position);
}
