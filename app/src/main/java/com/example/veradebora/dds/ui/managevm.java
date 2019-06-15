package com.example.veradebora.dds.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import com.example.veradebora.dds.Object.DetailsOfVmObject;
import com.example.veradebora.dds.Object.VmObject;
import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.ExpandableListAdapter;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.UserVmList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class managevm extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    public TextView tvusername;
    public TextView tvBalance;
    public String username;
    public String uBalance;
    private JsonPlaceHolderApi api;
    public Context mContext;
    public String UserId;
    private ExpandableListView expandableListView;
    private List<VmObject> listVmTitle;
    private HashMap<VmObject, List<DetailsOfVmObject>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managevm);

        mContext = this;
        expandableListView = findViewById(R.id.expandable);
        api = UtilsApi.getAPIService();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("User_Name", "");
        UserId = sharedPreferences.getString("User_id", "");
        uBalance = sharedPreferences.getString("ubalance","");


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        tvusername = (TextView) headerview.findViewById(R.id.textView2);
        tvBalance = (TextView) headerview.findViewById(R.id.textView3);
        tvusername.setText(username);
        tvBalance.setText("Rp. " + uBalance);
        navigationView.setNavigationItemSelectedListener(this);

        prasangka();

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
                Intent j= new Intent(this,Billing.class);
                startActivity(j);
                break;
            case R.id.nav_managevm:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void prasangka(){

        api.USER_VM_LIST(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserVmList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserVmList userVmList) {



                        listVmTitle = new ArrayList<>();
                        listHashMap = new HashMap<>();
                        List<DetailsOfVmObject> detailsOfVmObjects = new ArrayList<>();

                        for (int i = 0; i < userVmList.getVm_data().size(); i++) {


                            //loop ExpandableListview RowTitle
                            VmObject vmObject = new VmObject(userVmList.getVm_data().get(i).getHostname(),
                                    userVmList.getVm_data().get(i).getStatus(), userVmList.getVm_data().get(i).getImage());
                            listVmTitle.add(vmObject);

                            //Loop ExpandableListview RowChildren
                            DetailsOfVmObject details = new DetailsOfVmObject(userVmList.getVm_data().get(i).getFlavor(),
                                    userVmList.getVm_data().get(i).getIp_vm());
                            detailsOfVmObjects.add(details);

                            //loop hashmap
                            listHashMap.put(listVmTitle.get(i),detailsOfVmObjects);
                        }



                        LayoutInflater layoutInflater = getLayoutInflater();
                        ViewGroup header = (ViewGroup)layoutInflater.inflate(R.layout.managevm_header,expandableListView,false);
                        expandableListView.addHeaderView(header);


                        ExpandableListAdapter adapter = new ExpandableListAdapter(mContext, listVmTitle,listHashMap,detailsOfVmObjects);
                        expandableListView.setAdapter(adapter);

                        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> false);

                    }
                });

    }



    public void logout(MenuItem item) {
        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("User_Name").apply();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }


}
