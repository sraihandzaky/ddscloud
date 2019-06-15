package com.example.veradebora.dds.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class selectos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String osname;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    public TextView tvusername;
    public TextView tvBalance;
    public String username;
    public String osid;
    public String uBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectos);

        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("User_Name", "");
        uBalance = sharedPreferences.getString("ubalance","");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        tvusername = headerview.findViewById(R.id.textView2);
        tvBalance = headerview.findViewById(R.id.textView3);
        tvusername.setText(username);
        tvBalance.setText("Rp. " + uBalance);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selectos, menu);
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
                Intent k= new Intent(this,managevm.class);
                startActivity(k);
                break;


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Request VM");
        builder.setPositiveButton("Default Size", (dialog, which) -> {
            //if user pressed "yes", then he is allowed to exit from application
            Intent intent = new Intent(selectos.this, selectdefsize.class);
            osname = "Debian 8 x64";
            osid = "75a86ebb-ed04-4f13-a9d5-daa5cd8acec2";
            intent.putExtra("osid", osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        builder.setNegativeButton("Custom Size", (dialog, which) -> {
            Intent intent = new Intent(selectos.this, fincust.class);
            osname = "Debian 8 x64";
            osid = "75a86ebb-ed04-4f13-a9d5-daa5cd8acec2";
            intent.putExtra("osid", osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void next2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Request VM");
        builder.setPositiveButton("Default Size", (dialog, which) -> {
            //if user pressed "yes", then he is allowed to exit from application
            Intent intent = new Intent(selectos.this, selectdefsize.class);
            osname = "CentOS 7 x64";
            osid = "665ee283-f781-4f39-b145-ceae23bcf8b1";
            intent.putExtra("osid", osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        builder.setNegativeButton("Custom Size", (dialog, which) -> {
            Intent intent = new Intent(selectos.this, fincust.class);
            osname = "CentOS 7 x64";
            osid = "665ee283-f781-4f39-b145-ceae23bcf8b1";
            intent.putExtra("osid", osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void next3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Request VM");
        builder.setPositiveButton("Default Size", (dialog, which) -> {
            //if user pressed "yes", then he is allowed to exit from application
            Intent intent = new Intent(selectos.this, selectdefsize.class);
            osname = "Ubuntu 16.04.2 x64";
            osid = "eef9d93d-c05c-45de-85c4-05561d9b959b";
            intent.putExtra("osid",osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        builder.setNegativeButton("Custom Size", (dialog, which) -> {
            Intent intent = new Intent(selectos.this, fincust.class);
            osname = "Ubuntu 16.04.2 x64";
            osid = "eef9d93d-c05c-45de-85c4-05561d9b959b";
            intent.putExtra("osid",osid);
            intent.putExtra("os",osname);
            startActivity(intent);
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
