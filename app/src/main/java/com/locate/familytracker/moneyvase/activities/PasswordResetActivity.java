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

public class PasswordResetActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout submitButton;
    ImageView imgBack;
    EditText editPassword,editPasswordConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        editPassword = (EditText)findViewById(R.id.editPassword);
        editPasswordConfirm = (EditText)findViewById(R.id.editPasswordConfirm);
        submitButton = (RelativeLayout)findViewById(R.id.submitButton);
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

    public void goToResetDoneActivity(){
        startActivity(new Intent(PasswordResetActivity.this,ResetDoneActivity.class));
    }


    public void checkInputs(){
        checkInternet();
        if (editPassword.getText().toString().isEmpty()){
            editPassword.setError("Please enter password");
            Toast.makeText(PasswordResetActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
        }
        else if (editPasswordConfirm.getText().toString().isEmpty()){
            editPasswordConfirm.setError("Please re-enter password");
            Toast.makeText(PasswordResetActivity.this, "Please re-enter password", Toast.LENGTH_SHORT).show();
        }
        else if (!editPassword.getText().toString().equals(editPasswordConfirm.getText().toString())){
            editPassword.setError("Password Mismatch");
            editPasswordConfirm.setError("Password Mismatch");
            Toast.makeText(PasswordResetActivity.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else {
            if (connected){
                goToResetDoneActivity();
            }else {
                Toast.makeText(PasswordResetActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
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
