package com.example.veradebora.dds.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.veradebora.dds.R;
import com.example.veradebora.dds.api.JsonPlaceHolderApi;
import com.example.veradebora.dds.api.UtilsApi;
import com.example.veradebora.dds.pojo.LoginResponse;
import com.example.veradebora.dds.pojo.UserSaldo;


import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Login extends AppCompatActivity {

    private JsonPlaceHolderApi api;
    public Context mContext;
    private EditText email,password;
    private Button login;
    public String IdUser;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        api = UtilsApi.getAPIService();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);


        SharedPreferences sharedPreferences = getSharedPreferences("Sementara", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("User_Name")){
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
        }

    }
    public void login(View view) {
        requestLogin();
    }
        public void requestLogin(){

            api.LoginRequest(email.getText().toString(), password.getText().toString())
                    .flatMap(loginResponse -> {
                        if(loginResponse.isResult()){
                            String UserName = loginResponse.getUser_data().getName();
                            String Userid = loginResponse.getUser_data().getUser_id();
                            String Uemail = loginResponse.getUser_data().getEmail();
                            IdUser = Userid;
                            SharedPreferences sharedPreferences = getSharedPreferences("Sementara",Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("User_Name",UserName);
                            editor.putString("User_Email", Uemail);
                            editor.putString("User_id",Userid);
                            editor.apply();
                        }


                        return api.USER_SALDO_OBSERVABLE(IdUser);
                    })
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
                                String  ubalance = userSaldo.getBil_data().getSaldo();
                                Intent intent = new Intent(Login.this,Home.class);
                                Toast.makeText(mContext,"Login Success",Toast.LENGTH_SHORT).show();
                                SharedPreferences sharedPreferences = getSharedPreferences("Sementara",Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("ubalance", ubalance);
                                editor.apply();
                                startActivity(intent);
                            }
                        }
                    });


        }


    public void onBackPressed() {
                finishAffinity();

    }
}
