package com.example.veradebora.dds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.veradebora.dds.Object.BillHistoryObject;
import com.example.veradebora.dds.Object.DetailsOfBillHistoObject;
import com.example.veradebora.dds.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class BillHistoAdapter extends BaseExpandableListAdapter {


    private Context mContext;
    private List<BillHistoryObject> BillHistoParent;
    private HashMap<BillHistoryObject, List<DetailsOfBillHistoObject>> hashMap;
    private List<DetailsOfBillHistoObject> detailsOfBillHistoObjects;

    public BillHistoAdapter(Context mContext,
                            List<BillHistoryObject> billHistoParent,
                            HashMap<BillHistoryObject, List<DetailsOfBillHistoObject>> hashMap,
                            List<DetailsOfBillHistoObject> detailsOfBillHistoObjects) {

        this.mContext = mContext;
        this.BillHistoParent = billHistoParent;
        this.hashMap = hashMap;
        this.detailsOfBillHistoObjects = detailsOfBillHistoObjects;
    }

    @Override
    public int getGroupCount() {
        return BillHistoParent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return BillHistoParent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hashMap.get(BillHistoParent.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final String host = BillHistoParent.get(groupPosition).getHostname();
        final String stat = BillHistoParent.get(groupPosition).getStatus();

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.bill_histo_parent,null);
        }

        TextView tvHostname = (TextView)convertView.findViewById(R.id.bill_parent1);
        TextView tvStatus = (TextView)convertView.findViewById(R.id.bill_parent2);

        tvHostname.setText(host);
        tvStatus.setText(stat);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String size = detailsOfBillHistoObjects.get(groupPosition).getFlavor();
        final String price= detailsOfBillHistoObjects.get(groupPosition).getPrice();
        final String total= detailsOfBillHistoObjects.get(groupPosition).getTotal();

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.bill_histo_children,null);
        }

        TextView tvSize = (TextView)convertView.findViewById(R.id.histochild1);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.histochild2);
        TextView tvTotal = (TextView)convertView.findViewById(R.id.histochild3);

        tvSize.setText(size);
        tvPrice.setText("Price/Hour =\t\t" + "Rp. " + price);
        tvTotal.setText("Total\t\t\t\t\t   =\t\t" + "Rp. " + total);

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
