package com.example.veradebora.dds.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.veradebora.dds.Object.VmObject;
import com.example.veradebora.dds.R;

import java.util.List;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class VmAdapter extends ArrayAdapter<VmObject> {

    private Context mContext;
    private int mResource;
    private List<VmObject> ArrayList;


    public VmAdapter(@NonNull Context context, int resource, @NonNull List<VmObject> objects) {
        super(context, resource, objects);
        mContext =  context;
        mResource= resource;
        ArrayList = objects;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String hostname = ArrayList.get(position).getHostName();
        String status = ArrayList.get(position).getStatus();
        String os = ArrayList.get(position).getOs();

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
        }
        TextView tvHostname = convertView.findViewById(R.id.hostname);
        TextView tvStatus = convertView.findViewById(R.id.os);
        TextView tvOs = convertView.findViewById(R.id.status);

        tvHostname.setText(hostname);
        tvStatus.setText(status);
        tvOs.setText(os);

        return convertView;
    }
}
