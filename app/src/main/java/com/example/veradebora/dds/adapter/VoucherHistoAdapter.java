package com.example.veradebora.dds.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.veradebora.dds.Object.VoucherHistoObject;
import com.example.veradebora.dds.R;

import java.util.List;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class VoucherHistoAdapter extends ArrayAdapter<VoucherHistoObject> {

    private Context mContext;
    private int mResource;
    private List<VoucherHistoObject> ArrayList;


    public VoucherHistoAdapter(@NonNull Context context, int resource, @NonNull List<VoucherHistoObject> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource= resource;
        this.ArrayList= objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String status   = ArrayList.get(position).getStatus();
        String date     = ArrayList.get(position).getDate();
        String amount   = ArrayList.get(position).getAmount();

        if (convertView == null ) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);
        }

        TextView tvStatus   = convertView.findViewById(R.id.fragrow1);
        TextView tvdate     = convertView.findViewById(R.id.fragrow2);
        TextView tvamount   = convertView.findViewById(R.id.fragrow3);


        tvStatus.setText(status);
        tvdate.setText(date);
        tvamount.setText("Rp. " + amount);

        return convertView;
    }

}
