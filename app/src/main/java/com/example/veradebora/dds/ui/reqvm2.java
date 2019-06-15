package com.example.veradebora.dds.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.RecyclerViewAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class reqvm2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;
//    CarouselPicker carousel1;
    public TextView username;
    public String namauser;
    public Integer vcpu=1, ram=1, storage=20;

    private static SeekBar seek_bar;
    private static TextView text_view;
    private static TextView text_view2;
    private static TextView text_view3;


    private static final String TAG = "reqvm2";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqvm2);


        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        namauser = sharedPreferences.getString("UserName","");





        //Seekbar
        seekvcpu();
        seekram();
        seekstorage();

//        carousel1 = (CarouselPicker) findViewById(R.id.carousel1);
//
//        //carousel1
//        List<CarouselPicker.PickerItem> OSItems = new ArrayList<>();
//        OSItems.add(new CarouselPicker.TextItem("Debian \n8 x64",8));
//        OSItems.add(new CarouselPicker.TextItem("CentOS \n7 x64",8));
//        OSItems.add(new CarouselPicker.TextItem("Ubuntu \n16.04.2 x64",8));
//        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this,OSItems,0);
//        carousel1.setAdapter(textAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        username = (TextView) headerview.findViewById(R.id.textView2);
        username.setText(namauser);
        navigationView.setNavigationItemSelectedListener(this);
        getImages();

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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void logout(MenuItem item) {
        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("UserName").commit();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void seekvcpu( ){
        seek_bar = (SeekBar) findViewById(R.id.seek1);
        text_view = (TextView) findViewById(R.id.txtvcpu);
        text_view.setText("1 vCPU");


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value=1;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                        text_view.setText(progress_value+ progress + " vCPU" );
                        vcpu= progress_value+progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void seekram( ){
        seek_bar = (SeekBar) findViewById(R.id.seek2);
        text_view2 = (TextView) findViewById(R.id.txtram);
        text_view2.setText("1 GB RAM");


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                        progress_value=1;
                        if (progress==0){
                            progress=0;
                        }else if (progress==1){
                            progress=1;
                        }else {
                            progress=3;
                        }
                        text_view2.setText(progress_value+progress + " GB RAM" );
                        ram= progress_value+progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void seekstorage(){
        seek_bar = (SeekBar) findViewById(R.id.seek3);
        text_view3 = (TextView) findViewById(R.id.txtstorage);
        text_view3.setText("20 GB Storage");


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value=20;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                        if (progress==0){
                            progress=0;
                        }else if(progress==1) {
                            progress=20;
                        }else{
                            progress=60;
                        }
                        text_view3.setText(progress_value+progress + " GB RAM" );
                        storage= progress_value+progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
    public void reqvm2(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("vCPU:\t\t\t\t"+vcpu+" vCPU\n"+
                "Memory:\t\t\t\t"+ram+" GB \n"+
                "Storage:\t\t\t\t"+storage+" GB \n"+
                "Cost per Hour:\t\t\t\t Rp 9.000.000\n"+
                "Cost per Month:\t\t\t\t Rp 99.000.000");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.v3.co.uk/w-images/fb8cb057-1288-44c3-a982-11bec8d99e3a/0/debianlogo-580x358.jpg");
        mNames.add("Debian 8x64");

        mImageUrls.add("https://assets.ubuntu.com/v1/8dd99b80-ubuntu-logo14.png");
        mNames.add("Ubuntu 16.04.2x64");

        mImageUrls.add("https://bgasparotto.com/wp-content/uploads/2017/10/install-centos-7-logo.png");
        mNames.add("CentOS 7x64");



        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }


}