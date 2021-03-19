package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.locate.familytracker.moneyvase.R;

public class ForgetActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout submitButton;
    ImageView imgBack;
    EditText editEmailMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        editEmailMobile = (EditText)findViewById(R.id.editEmailMobile);
        submitButton = (RelativeLayout)findViewById(R.id.submitButton);
        imgBack = (ImageView)findViewById(R.id.imgBack);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkInput();

            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void goToEnterCodeActivity(){
        startActivity(new Intent(ForgetActivity.this,ForgetCodeActivity.class));
    }

    public void checkInput(){
        checkInternet();
        if (editEmailMobile.getText().toString().isEmpty()){
            editEmailMobile.setError("Please enter email or mobile number");
            Toast.makeText(ForgetActivity.this, "Please enter email or mobile number", Toast.LENGTH_SHORT).show();
        }else {

            if (connected){
                goToEnterCodeActivity();
            }else {
                Toast.makeText(ForgetActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
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