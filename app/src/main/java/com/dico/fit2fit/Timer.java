package com.dico.fit2fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Timer extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;


    Button start, stop;
    Chronometer chronometer;
    long stopTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.startbtn);
        stop = findViewById(R.id.stopbtn);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "운동 시작", Toast.LENGTH_LONG).show();
                stopTime = 0;
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "운동 종료", Toast.LENGTH_LONG).show();
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                long work_time;
                work_time = stopTime;

                //stopTime을 파이어베이스로 넘기고 다시 기록화면으로 넘어가기
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }


}