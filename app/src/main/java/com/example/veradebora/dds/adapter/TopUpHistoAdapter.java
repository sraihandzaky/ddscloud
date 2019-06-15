package com.example.veradebora.dds.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.veradebora.dds.Object.TopUpHistoObject;
import com.example.veradebora.dds.R;

import java.util.List;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class TopUpHistoAdapter extends ArrayAdapter<TopUpHistoObject> {

    private Context mContext;
    private int mResource;
    private List<TopUpHistoObject> topupArray;

    public TopUpHistoAdapter(@NonNull Context context, int resource, @NonNull List<TopUpHistoObject> objects) {
        super(context, resource, objects);
        this.mContext   = context;
        this.mResource  = resource;
        this.topupArray = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String status   = topupArray.get(position).getStatus();
        String date     = topupArray.get(position).getDate();
        String amount   = topupArray.get(position).getAmount();

        if (convertView == null ) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);
        }

        TextView tvStatus   = convertView.findViewById(R.id.fragrow11);
        TextView tvdate     = convertView.findViewById(R.id.fragrow22);
        TextView tvamount   = convertView.findViewById(R.id.fragrow33);


        tvStatus.setText(status);
        tvdate.setText(date);
        tvamount.setText("Rp. " + amount);

        return convertView;
    }
}
