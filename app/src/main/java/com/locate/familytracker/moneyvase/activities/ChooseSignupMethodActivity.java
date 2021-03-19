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

import com.locate.familytracker.moneyvase.R;

public class ChooseSignupMethodActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout relEmail,relMobile;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_signup_method);

        imgBack = (ImageView)findViewById(R.id.imgBack);
        relEmail = (RelativeLayout)findViewById(R.id.relEmail);
        relMobile = (RelativeLayout)findViewById(R.id.relMobile);


        relEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUpAuthenticationCodeActivity();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });


        relMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSignUpAuthenticationCodeActivity();

            }
        });


    }

    public void   goToSignUpAuthenticationCodeActivity(){
        checkInternet();

        if (connected){
            startActivity(new Intent(ChooseSignupMethodActivity.this,SignUpAuthenticationCodeActivity.class));
        }else {
            Toast.makeText(ChooseSignupMethodActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
        }


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