package com.locate.familytracker.moneyvase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.locate.familytracker.moneyvase.R;
import com.locate.familytracker.moneyvase.fragments.AlertFragment;
import com.locate.familytracker.moneyvase.fragments.HomeFragment;
import com.locate.familytracker.moneyvase.fragments.SettingsFragment;

public class FragmentContainerActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        changeFragment(new HomeFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:
                    changeFragment(new HomeFragment());
                    return true;

                case R.id.alert:
                    changeFragment(new AlertFragment());
                    return true;

                case R.id.settings:

                    changeFragment(new SettingsFragment());
                    return true;

            }
            return false;
        }
    };


    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}