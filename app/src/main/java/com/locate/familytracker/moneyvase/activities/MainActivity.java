package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.locate.familytracker.moneyvase.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relLogin,relSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        relLogin = (RelativeLayout)findViewById(R.id.relLogin);
        relSignup = (RelativeLayout)findViewById(R.id.relSignup);


        relLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginActivity();
            }
        });

        relSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignupActivity();
            }
        });

    }

    public void goToLoginActivity(){
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    public void goToSignupActivity(){
        startActivity(new Intent(MainActivity.this,SignupActivity.class));
    }

}