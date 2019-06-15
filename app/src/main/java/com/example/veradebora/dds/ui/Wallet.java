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
import android.widget.Toast;

import com.example.veradebora.dds.R;
import com.example.veradebora.dds.adapter.PageAdapter;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.TopUpRequest;
import com.example.veradebora.dds.pojo.UserSaldo;
import com.example.veradebora.dds.pojo.VoucherResponse;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Wallet extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        TopUpDialog.TopUpDialogListener ,
        VoucherDialog.VoucherDialogListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    public TextView tvusername;
    public TextView tvBalance;
    public TextView tvSaldo;
    public String username;
    public String uBalance;
    public String UserId;
    public String bankname;
    public String KodeVoucher;
    public String Uemail;
    public int IdUser;
    public int norek;
    public int amount;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    public JsonPlaceHolderApi api;
    public Context mContext;
    public boolean Voucher = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        api = UtilsApi.getAPIService();
        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.tabChats);
        tabStatus = findViewById(R.id.tabStatus);
        viewPager = findViewById(R.id.viewPager);
        tvSaldo = findViewById(R.id.duit);

        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("User_Name", "");
        Uemail = sharedPreferences.getString("User_Email","");
        uBalance = sharedPreferences.getString("ubalance","");
        UserId = sharedPreferences.getString("User_id", "");
        IdUser = Integer.parseInt(UserId);




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
        tvSaldo.setText("Rp. " + uBalance);
        navigationView.setNavigationItemSelectedListener(this);

         pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
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

    public void reqtopup(View view) {
        TopUpDialog();
    }

    public void TopUpDialog(){
        TopUpDialog topUpDialog = new TopUpDialog();
        topUpDialog.show(getSupportFragmentManager(),"TopUp Dialog");
    }

    public void voucher(View view) {
        VoucherDialog();
    }

    public void VoucherDialog(){
        VoucherDialog voucherDialog = new VoucherDialog();
        voucherDialog.show(getSupportFragmentManager(),"Top Up Dialog");
    }

    public void saldo(){
        api.USER_SALDO_OBSERVABLE(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UserSaldo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext,"Something went wrong man!",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(UserSaldo userSaldo) {
                        if (userSaldo.isResult()) {
                            uBalance = userSaldo.getBil_data().getSaldo();
                            tvBalance.setText("Rp. " + uBalance);
                            tvSaldo.setText("Rp. " + uBalance);
                            SharedPreferences sharedPreferences = getSharedPreferences("Sementara",Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ubalance", uBalance);
                            editor.apply();

                        }
                    }
                });
    }

    @Override
    public void inputText(String VoucherCode, boolean voucher) {
        KodeVoucher = VoucherCode;
        Voucher = voucher;
        if (Voucher == true){
            api.VOUCHER_RESPONSE_OBSERVABLE(KodeVoucher, IdUser)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<VoucherResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(mContext,"Wrong Voucher Code!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNext(VoucherResponse voucherResponse) {
                            if (voucherResponse.isResult()){
                                Toast.makeText(mContext,"Voucher Code Accepted!",Toast.LENGTH_SHORT).show();
                                Voucher = false;
                                saldo();
                            }
                        }
                    });
        }
    }

    @Override
    public void applyTexts(int Nominal, String NamaBank, int RekNum) {
        amount = Nominal;
        bankname = NamaBank;
        norek = RekNum;
        if (bankname != null){
            api.TOP_UP_REQUEST_OBSERVABLE(amount, IdUser, bankname, Uemail, username, norek)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<TopUpRequest>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(mContext, "ERROR!", Toast.LENGTH_SHORT).show();
//                            amount = Integer.parseInt(null);
                            bankname = null;
//                            norek = Integer.parseInt(null);
                        }

                        @Override
                        public void onNext(TopUpRequest topUpRequest) {
                            if(topUpRequest.isResult()){
//                                amount = Integer.parseInt(null);
                                bankname = null;
//                                norek = Integer.parseInt(null);
                            }
                        }
                    });
        }
    }
}
