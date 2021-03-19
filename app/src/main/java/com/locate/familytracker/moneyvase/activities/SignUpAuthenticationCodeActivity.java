package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.locate.familytracker.moneyvase.R;

public class SignUpAuthenticationCodeActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout confirmButton;
    EditText editCode;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_authentication_code);

        imgBack = (ImageView)findViewById(R.id.imgBack);
        confirmButton = (RelativeLayout)findViewById(R.id.confirmButton);
        editCode = (EditText) findViewById(R.id.editCode);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkCodeInputs();

            }
        });

    }

    public void goToHomePage(){
        startActivity(new Intent(SignUpAuthenticationCodeActivity.this,MainActivity.class));
    }

    public void checkCodeInputs(){
        checkInternet();
        if (editCode.getText().toString().isEmpty()){
            editCode.setError("Please enter authentication code");
            Toast.makeText(SignUpAuthenticationCodeActivity.this, "Please enter authentication code", Toast.LENGTH_SHORT).show();
        }else {

            if (connected){
                goToHomePage();

            }else {
                Toast.makeText(SignUpAuthenticationCodeActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
            }

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