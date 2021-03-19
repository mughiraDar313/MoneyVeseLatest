package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.locate.familytracker.moneyvase.R;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class ResetDoneActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout submitButton;
    ImageView imgBack,imgGif;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_done);

        submitButton = (RelativeLayout)findViewById(R.id.submitButton);
        gifImageView = (GifImageView)findViewById(R.id.gifImageView);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternet();

                if (connected){
                    goToHomeActivity();
                }else {
                    Toast.makeText(ResetDoneActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public void goToHomeActivity(){
        startActivity(new Intent(ResetDoneActivity.this,MainActivity.class));
    }
    public void checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        }
        else
            connected = false;
    }

}
