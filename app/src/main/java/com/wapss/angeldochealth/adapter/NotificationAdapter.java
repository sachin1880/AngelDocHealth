package com.wapss.angeldochealth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wapss.angeldochealth.R;
import com.wapss.angeldochealth.response.NotificationResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{
    public static List<NotificationResponse.Result> ItemList;
    private Context context;

    public NotificationAdapter(Context context, List<NotificationResponse.Result> notification) {
        this.ItemList = notification;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification, parent, false);
        NotificationAdapter.ViewHolder viewHolder = new NotificationAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        holder.notification_title.setText(ItemList.get(position).getTitle());
        holder.notification_desc.setText(ItemList.get(position).getDesc());
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date9 = null;//You will get date object relative to server/client timezone wherever it is parsed
        try {
            date9 = dateFormat1.parse(ItemList.get(position).getCreatedAt());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        DateFormat formatter9 = new SimpleDateFormat("dd-MM-yyyy"); //If you need time just put specific format for time like 'HH:mm:ss'
        String dateStr = formatter9.format(date9);

        holder.notification_date.setText(dateStr);
    }

    @Override
    public int getItemCount() {
        if (ItemList == null) return 0;
        return ItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView notification_title,notification_desc,notification_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notification_title = (TextView) itemView.findViewById(R.id.notification_title);
            notification_desc = (TextView) itemView.findViewById(R.id.notification_desc);
            notification_date = (TextView) itemView.findViewById(R.id.notification_date);
        }
    }
}
