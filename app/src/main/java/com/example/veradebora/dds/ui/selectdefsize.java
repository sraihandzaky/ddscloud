package com.example.veradebora.dds.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.veradebora.dds.R;

public class selectdefsize extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String osnem,vcpu,memory,storage,cost;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    public TextView tvusername;
    public TextView tvBalance;
    public String username;
    public String uBalance;
    public String flavor;
    public String osid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectdefsize);

        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("User_Name", "");
        uBalance = sharedPreferences.getString("ubalance","");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        osnem= getIntent().getExtras().getString("os");
        osid = getIntent().getExtras().getString("osid");

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
        getMenuInflater().inflate(R.menu.selectdefsize, menu);
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
            case R.id.nav_managevm:
                Intent k= new Intent(this,managevm.class);
                startActivity(k);
                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void logout(MenuItem item) {
        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("User_Name").apply();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
    public void next1(View view) {
        Intent intent = new Intent(this, findef.class);
        intent.putExtra("os2", osnem);
        intent.putExtra("osid",osid);
        vcpu="1";
        memory="1";
        storage="20";
        flavor= "1_1_20";
        cost="50";
        intent.putExtra("vcpu", vcpu);
        intent.putExtra("memory", memory);
        intent.putExtra("storage", storage);
        intent.putExtra("cost",cost);
        intent.putExtra("flavor", flavor);
        startActivity(intent);
    }

    public void next2 (View view) {
        Intent intent = new Intent(this, findef.class);
        intent.putExtra("os2", osnem);
        intent.putExtra("osid",osid);
        vcpu="2";
        memory="2";
        storage="20";
        flavor="2_2_20";
        cost="120";
        intent.putExtra("vcpu", vcpu);
        intent.putExtra("memory", memory);
        intent.putExtra("storage", storage);
        intent.putExtra("cost",cost);
        intent.putExtra("flavor",flavor);
        startActivity(intent);
    }
    public void next3(View view) {
        Intent intent = new Intent(this, findef.class);
        intent.putExtra("os2", osnem);
        intent.putExtra("osid",osid);
        vcpu="2";
        memory="2";
        storage="80";
        flavor="2_2_80";
        cost="160";
        intent.putExtra("vcpu", vcpu);
        intent.putExtra("memory", memory);
        intent.putExtra("storage", storage);
        intent.putExtra("cost",cost);
        intent.putExtra("flavor",flavor);
        startActivity(intent);
    }
    public void next4(View view) {
        Intent intent = new Intent(this, findef.class);
        intent.putExtra("os2", osnem);
        intent.putExtra("osid",osid);
        vcpu="2";
        memory="4";
        storage="40";
        flavor="2_4_40";
        cost="180";
        intent.putExtra("vcpu", vcpu);
        intent.putExtra("memory", memory);
        intent.putExtra("storage", storage);
        intent.putExtra("cost",cost);
        intent.putExtra("flavor",flavor);
        startActivity(intent);
    }
}
