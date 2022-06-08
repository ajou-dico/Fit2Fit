package com.dico.fit2fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
    viewModel viewModel1;
    Button start, stop;
    Chronometer chronometer;

    long stopTime = 0;
    int weight;
    int total_time = 0;
    int work_time = 0;
    int Kcal = 0;
    dashboard dash;


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

        System.out.println("[Intent Data] " + exerciseType + ", " + todayDate);

        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.startbtn);
        stop = findViewById(R.id.stopbtn);

//        viewModel1 = new ViewModelProvider(this, new NameViewModelFactory()).get(viewModel.class);
//        뷰모델로 total 하려고 했는데 실패

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
                chronometer.stop();
                stopTime = chronometer.getBase() - SystemClock.elapsedRealtime();
                work_time = (int) stopTime;
                work_time = -work_time/1000;
                total(work_time);
                Toast toast = Toast.makeText(getApplicationContext(), "Toast test", Toast.LENGTH_SHORT);
                toast.setText("운동 종료");
                toast.show();
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
        data.put("Totalsec: ", total_time);
        DR.update("calories ",Kcal, "exerciseSec: ", work_time,"Totalsec: ",total_time ).addOnSuccessListener(new OnSuccessListener<Void>() {
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

    public void total(int v){
        total_time = total_time + v;


    }

}