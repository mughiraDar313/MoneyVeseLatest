package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.locate.familytracker.moneyvase.R;

public class LoginActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout loginButton;
    ImageView imgBack;
    TextView txtFogetPassword,txtRegisterUSer;
    EditText editEmail,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (RelativeLayout)findViewById(R.id.loginButton);
        imgBack = (ImageView)findViewById(R.id.imgBack);
        txtRegisterUSer = (TextView)findViewById(R.id.txt2);
        txtFogetPassword = (TextView)findViewById(R.id.txtFogetPassword);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword = (EditText)findViewById(R.id.editPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLoginInputs();

            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txtFogetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToForgetActivity();

            }
        });
        txtRegisterUSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSignupActivity();

            }
        });

    }

    public void goToSignupActivity(){
        startActivity(new Intent(LoginActivity.this,SignupActivity.class));
    }
    public void goToForgetActivity(){
        startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
    }
    public void goToHomeActivity(){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
    public void checkLoginInputs(){
        checkInternet();
        if (editEmail.getText().toString().isEmpty()){
            editEmail.setError("Please enter email or mobile number");
            Toast.makeText(LoginActivity.this, "Please enter email or mobile number", Toast.LENGTH_SHORT).show();
        }
        else if (editPassword.getText().toString().isEmpty()){
            editPassword.setError("Please enter password");
            Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
        }
        else {
            if (connected){
                loginUser(editEmail.getText().toString() , editPassword.getText().toString());
            }else {
                Toast.makeText(LoginActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void loginUser(String email , String password){
        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
        goToHomeActivity();
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