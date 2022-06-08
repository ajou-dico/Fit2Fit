package com.dico.fit2fit;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private BottomNavigationView bottomNavigationView;
    private Fragment dashboard_f;
    private Fragment options_f;
    private Fragment recording_f;
    private Fragment workout_f;
    private Fragment dashboard_f1;
    int change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboard_f1 = new dashboard_init();
        dashboard_f = new dashboard();
        options_f = new options();
        recording_f = new recording();
        workout_f = new workout();

        Intent intent = getIntent();
        change = intent.getIntExtra("dash",0);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        if(change == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboard_f).commit();
        } else{
            getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboard_f1).commit();
        }
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_dashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboard_f).commitAllowingStateLoss();
                        return true;
                    case R.id.navigation_recording:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, recording_f).commitAllowingStateLoss();
                        return true;
                    case R.id.navigation_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, options_f).commitAllowingStateLoss();
                        return true;
                }
                return false;
            }
        });
    }

    public void onFragmentChange(int fragNum) {
        //프래그먼트의 번호에 따라 다르게 작동하는 조건문
        if(fragNum == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, workout_f).commitAllowingStateLoss();
        } else if(fragNum == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, recording_f).commitAllowingStateLoss();
        } else if(fragNum == 3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboard_f).commitAllowingStateLoss();
        }
    }

}