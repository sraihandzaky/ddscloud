package com.example.veradebora.dds.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.veradebora.dds.Object.VoucherHistoObject;
import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.VoucherHistoAdapter;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.VoucherHistoResponse;

import java.util.ArrayList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class voucher extends Fragment {

    public JsonPlaceHolderApi api;
    public Context mContext;
    public String UserId;
    private ListView listView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        api = UtilsApi.getAPIService();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        UserId = sharedPreferences.getString("User_id", "");
        View rootView = inflater.inflate(R.layout.fragment_voucher, container, false);
        listView = rootView.findViewById(R.id.voucherhistolv);


        VoucherHisto();

//        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return rootView;


    }


    public void VoucherHisto (){

        api.VOUCHER_HISTO_RESPONSE_OBSERVABLE(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VoucherHistoResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(VoucherHistoResponse voucherHistoResponse) {

                        ArrayList<VoucherHistoObject> vhistolist = new ArrayList<>();

                        for (int i = 0; i < voucherHistoResponse.getV_data().size(); i++){

                            VoucherHistoObject voucherHistoObject = new VoucherHistoObject(
                                    voucherHistoResponse.getV_data().get(i).getStatus(),
                                    voucherHistoResponse.getV_data().get(i).getUpdated_at(),
                                    voucherHistoResponse.getV_data().get(i).getAmount());
                            vhistolist.add(voucherHistoObject);

                        }

                        LayoutInflater layoutInflater = getLayoutInflater();
                        ViewGroup header = (ViewGroup)layoutInflater.inflate(R.layout.fragment_voucher_header,listView,false);
                        listView.addHeaderView(header);

                        VoucherHistoAdapter adapter = new VoucherHistoAdapter(getActivity().getApplicationContext(),R.layout.fragment_voucher_row,vhistolist);
                        listView.setAdapter(adapter);


                    }
                });

    }


}
