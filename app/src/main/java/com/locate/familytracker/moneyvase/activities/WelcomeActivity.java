package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.locate.familytracker.moneyvase.R;

public class WelcomeActivity extends AppCompatActivity {

    RelativeLayout startedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        startedButton = (RelativeLayout)findViewById(R.id.startedButton);

        startedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               moveToMainActivity();
            }
        });

    }

    public void moveToMainActivity(){
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }
}