package com.wapss.angeldochealth.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.interfaces.ViewTodayAppointmentListener;
import com.wapss.angeldochealth.response.Banner_Response;
import com.wapss.angeldochealth.response.TodayResponse;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TodayAppointmentAdapter extends RecyclerView.Adapter<TodayAppointmentAdapter.ViewHolder> {
    public List<TodayResponse.Result> ItemList;
    Context context;
    ViewTodayAppointmentListener listener;

    public TodayAppointmentAdapter(Context context, List<TodayResponse.Result> ItemList, ViewTodayAppointmentListener listener) {
        this.ItemList = ItemList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodayAppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_question, parent, false);
        TodayAppointmentAdapter.ViewHolder viewHolder = new TodayAppointmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TodayAppointmentAdapter.ViewHolder holder, int position) {
        holder.txt_name.setText(ItemList.get(position).getPatientDetail().getName());
        holder.gender.setText(ItemList.get(position).getPatientDetail().getGender());
        holder.age.setText(ItemList.get(position).getPatientDetail().getDob());
        holder.dates.setText(ItemList.get(position).getBookingDate());
        holder.time.setText(ItemList.get(position).getPeriod().getTimeStart() + "" + ItemList.get(position).getPeriod().getTimeEnd());
        holder.tv_address.setText(ItemList.get(position).getPatientDetail().getCity());
    }

    @Override
    public int getItemCount() {
        if (ItemList == null) return 0;
        return ItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView cv_icon;
        TextView txt_name, gender, age, dates, time,tv_address;
        LinearLayout tv_show_Details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_icon = (CircleImageView) itemView.findViewById(R.id.cv_icon);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            gender = (TextView) itemView.findViewById(R.id.gender);
            age = (TextView) itemView.findViewById(R.id.age);
            dates = (TextView) itemView.findViewById(R.id.dates);
            time = (TextView) itemView.findViewById(R.id.time);
            tv_show_Details = (LinearLayout) itemView.findViewById(R.id.tv_show_Details);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);

            tv_show_Details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickedItem(ItemList.get(getAdapterPosition()), getAdapterPosition());
                }
            });
        }
    }
}
