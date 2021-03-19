package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.locate.familytracker.moneyvase.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                moveActivity();

            }
        },2000);

    }

    public void moveActivity(){
        startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
        finish();
    }


}