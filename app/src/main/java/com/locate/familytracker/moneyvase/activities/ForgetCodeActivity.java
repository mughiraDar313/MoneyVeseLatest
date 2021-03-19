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

public class ForgetCodeActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout submitButton;
    ImageView imgBack;
    EditText editResetCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_code);

        submitButton = (RelativeLayout)findViewById(R.id.submitButton);
        editResetCode = (EditText)findViewById(R.id.editResetCode);
        imgBack = (ImageView)findViewById(R.id.imgBack);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkInputs();

            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void goToEnterPasswordResetActivity(){
        startActivity(new Intent(ForgetCodeActivity.this,PasswordResetActivity.class));
    }

    public void checkInputs(){
        checkInternet();
        if (editResetCode.getText().toString().isEmpty()){
            editResetCode.setError("Please enter authentication code");
            Toast.makeText(ForgetCodeActivity.this, "Please enter authentication code", Toast.LENGTH_SHORT).show();
        }else {
            if (connected){
                goToEnterPasswordResetActivity();
            }else {
                Toast.makeText(ForgetCodeActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
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