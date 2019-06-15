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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veradebora.dds.R;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.VmRequest;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class findef extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private JsonPlaceHolderApi api;
    public TextView os;
    public TextView vcpu;
    public TextView memory;
    public TextView storage;
    public TextView cost;
    public TextView tvusername;
    public TextView tvBalance;
    public String dos;
    public String dvcpu;
    public String dmemory;
    public String dstorage;
    public String dcost;
    public String username;
    public String uBalance;
    public String osid;
    public String UserId;
    public String flavor;
    public String Uemail;
    public int intUserId;
    public EditText vmnem;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findef);

        api = UtilsApi.getAPIService();
        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username    = sharedPreferences.getString("User_Name", "");
        uBalance    = sharedPreferences.getString("ubalance","");
        UserId      = sharedPreferences.getString("User_id","");
        Uemail = sharedPreferences.getString("User_Email","");
        intUserId   = Integer.parseInt(UserId);


        osid        = getIntent().getExtras().getString("osid");
        flavor      = getIntent().getExtras().getString("flavor");
        dos         = getIntent().getExtras().getString("os2");
        dvcpu       = getIntent().getExtras().getString("vcpu");
        dmemory     = getIntent().getExtras().getString("memory");
        dstorage    = getIntent().getExtras().getString("storage");
        dcost       = getIntent().getExtras().getString("cost");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        os = findViewById(R.id.osnem);
        vcpu = findViewById(R.id.vcpu);
        memory = findViewById(R.id.memory);
        storage = findViewById(R.id.storage);
        vmnem = findViewById(R.id.vmnem);
        cost= findViewById(R.id.cost);

        os.setText(dos);
        vcpu.setText("vCPU: "+ dvcpu + " vCPU");
        memory.setText("Memory: "+ dmemory + " GB");
        storage.setText("Storage: "+ dstorage + " GB");
        cost.setText(dcost+" Rupiah/ Hour");



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
        getMenuInflater().inflate(R.menu.findef, menu);
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
    public void finish(View view) {
        if(vmnem.getText().toString().trim().length() == 0){
            Toast.makeText(this,"Please Enter VM Name",Toast.LENGTH_SHORT).show();
        }
        else {
            lastdialog();
        }

    }

    public void reqvm (){

        api.VM_REQUEST_OBSERVABLE(username, intUserId, osid, flavor, vmnem.getText().toString(), Uemail)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VmRequest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(VmRequest vmRequest) {


                    }
                });

    }

    public void lastdialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Create this VM?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            //if user pressed "yes", then he is allowed to exit from application
            reqvm();
            dialog.dismiss();
            Toast.makeText(findef.this,"Your Vm Has Been Requested",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(findef.this, Home.class);
            startActivity(i);


        });
        builder.setNegativeButton("No", (dialog, which) -> {
            //if user pressed "yes", then he is allowed to exit from application
            dialog.dismiss();

        });

        AlertDialog alert = builder.create();
        alert.show();

    }

}
