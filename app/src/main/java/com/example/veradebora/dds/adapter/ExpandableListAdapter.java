package com.example.veradebora.dds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.veradebora.dds.Object.DetailsOfVmObject;
import com.example.veradebora.dds.Object.VmObject;
import com.example.veradebora.dds.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<VmObject> listVmTitle;
    private HashMap<VmObject, List<DetailsOfVmObject>> listHashMap;
    private List<DetailsOfVmObject> detailsOfVmObjects;

    public ExpandableListAdapter(Context mContext,
                                 List<VmObject> listVmTitle,
                                 HashMap<VmObject, List<DetailsOfVmObject>> listHashMap,
                                 List<DetailsOfVmObject> detailsOfVmObjects ) {
        this.mContext = mContext;
        this.listVmTitle = listVmTitle;
        this.listHashMap = listHashMap;
        this.detailsOfVmObjects = detailsOfVmObjects;
    }

    @Override
    public int getGroupCount() {
        return listVmTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        return listHashMap.get(listVmTitle.get(groupPosition)).size();
        return 1;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return listVmTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listVmTitle.get(groupPosition)).get(childPosition);
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
        final String VmHostName = listVmTitle.get(groupPosition).getHostName();
        final String VmStatus = listVmTitle.get(groupPosition).getStatus();
        final String VmOs = listVmTitle.get(groupPosition).getOs();

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.managevm_row,null);
        }

        TextView tvHostname = (TextView) convertView.findViewById(R.id.FirstText1);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.SecondText2);
        TextView tvOs = (TextView) convertView.findViewById(R.id.ThirdText3);

        tvHostname.setText(VmHostName);
        tvStatus.setText(VmStatus);
        tvOs.setText(VmOs);

        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String Flavor = detailsOfVmObjects.get(groupPosition).getFlavor();
        String Ip = detailsOfVmObjects.get(groupPosition).getIpAddress();

        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.managevm_row_children,null);

        }

        TextView TvFlavor = (TextView) convertView.findViewById(R.id.expandable1);
        TextView TvIp = (TextView) convertView.findViewById(R.id.expandable2);

        TvFlavor.setText(Flavor);
        TvIp.setText("Vm Ip \t\t= \t\t" + Ip);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
