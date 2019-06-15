package com.example.veradebora.dds.ui;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.veradebora.dds.Object.TopUpHistoObject;
import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.TopUpHistoAdapter;
import com.example.veradebora.dds.adapter.VoucherHistoAdapter;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.TopUpHistoResponse;

import java.util.ArrayList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class tmoney extends Fragment {

    public JsonPlaceHolderApi api;
    public Context mContext;
    public String UserId;
    private ListView listView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        api = UtilsApi.getAPIService();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Sementara",Context.MODE_PRIVATE);
        UserId = sharedPreferences.getString("User_id", "");
        View rootView = inflater.inflate(R.layout.fragment_tmoney, container, false);
        listView = rootView.findViewById(R.id.topuphistolv);

       historia();

        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return rootView;
    }

    public void historia () {

        api.TOP_UP_HISTO_RESPONSE_OBSERVABLE(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TopUpHistoResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TopUpHistoResponse topUpHistoResponse) {

                        ArrayList <TopUpHistoObject> list = new ArrayList<>();

                        for (int r = 0; r<topUpHistoResponse.getBil_data().size(); r++ ){

                            TopUpHistoObject topUpHistoObject = new TopUpHistoObject(
                                    topUpHistoResponse.getBil_data().get(r).getStatus(),
                                    topUpHistoResponse.getBil_data().get(r).getDate(),
                                    topUpHistoResponse.getBil_data().get(r).getAmount());
                            list.add(topUpHistoObject);

                        }

                        LayoutInflater layoutInflater = getLayoutInflater();
                        ViewGroup header = (ViewGroup)layoutInflater.inflate(R.layout.fragment_topup_header,listView,false);
                        listView.addHeaderView(header);

                        TopUpHistoAdapter topUpHistoAdapter = new TopUpHistoAdapter(getActivity().getApplicationContext(),R.layout.fragment_topup_row,list);
                        listView.setAdapter(topUpHistoAdapter);


                    }
                });
    }
}
