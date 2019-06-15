package com.example.veradebora.dds.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.veradebora.dds.Object.BillHistoryObject;
import com.example.veradebora.dds.Object.DetailsOfBillHistoObject;
import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.BillHistoAdapter;
import com.example.veradebora.dds.adapter.PageAdapter;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.BillingHistoryResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Billing extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar = null;
    public TextView tvusername;
    public TextView tvBalance;
    public String username;
    public String uBalance;
    public JsonPlaceHolderApi api;
    private ExpandableListView histoExpandable;
    public Context mContext;
    public String UserId;
    private List<BillHistoryObject> BillHistoParent;
    private HashMap<BillHistoryObject, List<DetailsOfBillHistoObject>> hashMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        histoExpandable = (ExpandableListView)findViewById(R.id.histoexpand);
        mContext = this;
        api = UtilsApi.getAPIService();

        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("User_Name", "");
        uBalance = sharedPreferences.getString("ubalance","");
        UserId = sharedPreferences.getString("User_id", "");



        BillingVm();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        tvusername = headerview.findViewById(R.id.textView2);
        tvBalance = headerview.findViewById(R.id.textView3);
        tvusername.setText(username);
        tvBalance.setText(uBalance);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id=item.getItemId();
        switch (id){

            case R.id.nav_dashboard:
                Intent h= new Intent(this,Home.class);
                startActivity(h);
                break;
            case R.id.nav_Wallet:
                Intent i= new Intent(this,Wallet.class);
                startActivity(i);
                break;
            case R.id.nav_billing:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
            case R.id.nav_managevm:
                Intent k= new Intent(this,managevm.class);
                startActivity(k);
                break;


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void BillingVm(){
        api.BILLING_HISTORY_RESPONSE_OBSERVABLE(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BillingHistoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BillingHistoryResponse billingHistoryResponse) {

                        BillHistoParent = new ArrayList<>();
                        hashMap = new HashMap<>();
                        List<DetailsOfBillHistoObject> detailsOfBillHistoObjects = new ArrayList<>();

                        for (int i = 0; i < billingHistoryResponse.getTrans_data().size(); i++){

                            //loop ExpandableListview Parent
                            BillHistoryObject billHistoryObject = new BillHistoryObject(
                                    billingHistoryResponse.getTrans_data().get(i).getHostname(),
                                    billingHistoryResponse.getTrans_data().get(i).getStatus());
                            BillHistoParent.add(billHistoryObject);

                            //Loop ExpandableListview Children
                            DetailsOfBillHistoObject details = new DetailsOfBillHistoObject(
                                    billingHistoryResponse.getTrans_data().get(i).getId_flavor(),
                                    billingHistoryResponse.getTrans_data().get(i).getPrice(),
                                    billingHistoryResponse.getTrans_data().get(i).getAmount());
                            detailsOfBillHistoObjects.add(details);

                            //Loop Hashmap
                            hashMap.put(BillHistoParent.get(i),detailsOfBillHistoObjects);


                        }

                        LayoutInflater inflater = getLayoutInflater();
                        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.bill_histo_header,histoExpandable,false);
                        histoExpandable.addHeaderView(header);

                        BillHistoAdapter billHistoAdapter = new BillHistoAdapter(mContext,BillHistoParent,hashMap,detailsOfBillHistoObjects);
                        histoExpandable.setAdapter(billHistoAdapter);

                        histoExpandable.setOnGroupClickListener((parent, v, groupPosition, id) -> false);
                    }
                });
    }

    public void logout(MenuItem item) {
        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("User_Name").commit();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}
