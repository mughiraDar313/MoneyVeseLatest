package com.locate.familytracker.moneyvase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.locate.familytracker.moneyvase.R;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {
    boolean connected = false;
    RelativeLayout signupButton;
    ImageView imgBack;
    EditText editUserName,editGivenName,editSurname,editMobile,editEmail,editPassword,editPasswordConfirm;
    TextView editDob;
    TextView userAgreement,privacyPolicy;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        editUserName = (EditText)findViewById(R.id.editUserName);
        editGivenName = (EditText)findViewById(R.id.editGivenName);
        editSurname = (EditText)findViewById(R.id.editSurname);
        editDob = (TextView)findViewById(R.id.editDob);
        editMobile = (EditText)findViewById(R.id.editMobile);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPassword = (EditText)findViewById(R.id.editPassword);
        editPasswordConfirm = (EditText)findViewById(R.id.editPasswordConfirm);
        userAgreement = (TextView)findViewById(R.id.txt6);
        privacyPolicy = (TextView)findViewById(R.id.txt7);


        signupButton = (RelativeLayout)findViewById(R.id.loginButton);
        imgBack = (ImageView)findViewById(R.id.imgBack);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onBackPressed();
            }
        });


        userAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUserAggreementPage();
            }
        });
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPrivacyPolicy();
            }
        });

        editDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInputs();
            }
        });


    }

    public void goToChooseSignupMethodActivity(){
        startActivity(new Intent(SignupActivity.this,ChooseSignupMethodActivity.class));
    }

    public void goToUserAggreementPage(){
        Toast.makeText(SignupActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
    }

    public void goToPrivacyPolicy(){
        Toast.makeText(SignupActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
    }
    public void showDatePicker(){

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        editDob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void checkInputs(){
        checkInternet();
        if (editUserName.getText().toString().isEmpty()){
            editUserName.setError("Please enter username");
            Toast.makeText(SignupActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
        }
        else if (editGivenName.getText().toString().isEmpty()){
            editGivenName.setError("Please enter given name");
            Toast.makeText(SignupActivity.this, "Please enter given name", Toast.LENGTH_SHORT).show();
        }
        else if (editSurname.getText().toString().isEmpty()){
            editSurname.setError("Please enter surname");
            Toast.makeText(SignupActivity.this, "Please enter surname", Toast.LENGTH_SHORT).show();
        }
        else if (editDob.getText().toString().isEmpty()){
            editDob.setError("Please enter date of birth");
            Toast.makeText(SignupActivity.this, "Please enter date of birth", Toast.LENGTH_SHORT).show();
        }
        else if (editMobile.getText().toString().isEmpty()){
            editMobile.setError("Please enter mobile number");
            Toast.makeText(SignupActivity.this, "Please enter mobile number", Toast.LENGTH_SHORT).show();
        }
        else if (editEmail.getText().toString().isEmpty()){
            editEmail.setError("Please enter email");
            Toast.makeText(SignupActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
        }
        else if (editPassword.getText().toString().isEmpty()){
            editPassword.setError("Please enter password");
            Toast.makeText(SignupActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
        }
        else if (editPasswordConfirm.getText().toString().isEmpty()){
            editPasswordConfirm.setError("Please re-enter password");
            Toast.makeText(SignupActivity.this, "Please re-enter password", Toast.LENGTH_SHORT).show();
        }
        else if (!editPassword.getText().toString().equals(editPasswordConfirm.getText().toString())){
            editPassword.setError("Mismatch Password");
            editPasswordConfirm.setError("Mismatch Password");
            Toast.makeText(SignupActivity.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else {


            if (connected){
                goToChooseSignupMethodActivity();
            }else {
                Toast.makeText(SignupActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
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