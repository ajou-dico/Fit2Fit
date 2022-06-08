package com.dico.fit2fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;


public class Timer extends AppCompatActivity {
    private static final String TAG = "Tag";

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    Button start, stop;
    Chronometer chronometer;

    long stopTime = 0;
    long total_time = 0;

    int weight;
    int work_time;
    int Kcal;

    String exerciseType;
    String todayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Intent intent = getIntent();

        exerciseType = intent.getStringExtra("exerciseType");
        todayDate = intent.getStringExtra("todayDate");

        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.startbtn);
        stop = findViewById(R.id.stopbtn);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "운동 시작", Toast.LENGTH_SHORT).show();
                stopTime = 0;
                chronometer.setBase(SystemClock.elapsedRealtime() + stopTime);
                chronometer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "운동 종료", Toast.LENGTH_SHORT).show();
                chronometer.stop();
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                work_time = (int) stopTime;
                work_time = -work_time/1000;
                total_time += work_time;
                Kcal = 93*work_time/60;
                setTime();
                //stopTime을 파이어베이스로 넘기고 다시 기록화면으로 넘어가기
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void setTime() {
        DocumentReference DR = db.collection("Users").document(user.getUid());
        Map<String, Object> data = new HashMap<>();
        data.put("calories ", Kcal);
        data.put("exerciseSec: ", work_time);
        DR.update("calories ",Kcal, "exerciseSec: ", work_time ).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }
}