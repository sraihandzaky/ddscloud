package com.example.veradebora.dds.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.veradebora.dds.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT= 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(Splash.this, Login.class);
                startActivity(homeintent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
