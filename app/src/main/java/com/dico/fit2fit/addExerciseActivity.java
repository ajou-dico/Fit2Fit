package com.dico.fit2fit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addExerciseActivity extends AppCompatActivity {

    Button burpeeStart, crunchStart, jumpingjackStart, lungeStart, pushupStart, situpStart, squatStart, plankStart, legraiseStart;
    String todayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        todayDate = intent.getStringExtra("todayDate");

        burpeeStart = findViewById(R.id.btn_burpee);
        crunchStart = findViewById(R.id.btn_crunch);
        jumpingjackStart = findViewById(R.id.btn_jumpingjack);
        lungeStart = findViewById(R.id.btn_lunge);
        pushupStart = findViewById(R.id.btn_pushup);
        situpStart = findViewById(R.id.btn_situp);
        squatStart = findViewById(R.id.btn_squat);
        plankStart = findViewById(R.id.btn_plank);
        legraiseStart = findViewById(R.id.btn_legraise);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.btn_burpee:
                        Intent intent = new Intent(addExerciseActivity.this, Timer.class);
                        intent.putExtra("ExerciseType", "burpee");
                        intent.putExtra("todayDate", todayDate);
                        startActivity(intent);
                        break;
                    case R.id.btn_crunch:
                        Intent intent1 = new Intent(addExerciseActivity.this, Timer.class);
                        intent1.putExtra("ExerciseType", "crunch");
                        intent1.putExtra("todayDate", todayDate);
                        startActivity(intent1);
                        break;
                    case R.id.btn_jumpingjack:
                        Intent intent2 = new Intent(addExerciseActivity.this, Timer.class);
                        intent2.putExtra("ExerciseType", "jumpingjack");
                        intent2.putExtra("todayDate", todayDate);
                        startActivity(intent2);
                        break;
                    case R.id.btn_lunge:
                        Intent intent3 = new Intent(addExerciseActivity.this, Timer.class);
                        intent3.putExtra("ExerciseType", "lunge");
                        intent3.putExtra("todayDate", todayDate);
                        startActivity(intent3);
                        break;
                    case R.id.btn_pushup:
                        Intent intent4 = new Intent(addExerciseActivity.this, Timer.class);
                        intent4.putExtra("ExerciseType", "pushup");
                        intent4.putExtra("todayDate", todayDate);
                        startActivity(intent4);
                        break;
                    case R.id.btn_situp:
                        Intent intent5 = new Intent(addExerciseActivity.this, Timer.class);
                        intent5.putExtra("ExerciseType", "situp");
                        intent5.putExtra("todayDate", todayDate);
                        startActivity(intent5);
                        break;
                    case R.id.btn_squat:
                        Intent intent6 = new Intent(addExerciseActivity.this, Timer.class);
                        intent6.putExtra("ExerciseType", "squat");
                        intent6.putExtra("todayDate", todayDate);
                        startActivity(intent6);
                        break;
                    case R.id.btn_plank:
                        Intent intent7 = new Intent(addExerciseActivity.this, Timer.class);
                        intent7.putExtra("ExerciseType", "plank");
                        intent7.putExtra("todayDate", todayDate);
                        startActivity(intent7);
                        break;
                    case R.id.btn_legraise:
                        Intent intent8 = new Intent(addExerciseActivity.this, Timer.class);
                        intent8.putExtra("ExerciseType", "legraise");
                        intent8.putExtra("todayDate", todayDate);
                        startActivity(intent8);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }
            }
        };

        burpeeStart.setOnClickListener(onClickListener);
        crunchStart.setOnClickListener(onClickListener);
        jumpingjackStart.setOnClickListener(onClickListener);
        lungeStart.setOnClickListener(onClickListener);
        pushupStart.setOnClickListener(onClickListener);
        situpStart.setOnClickListener(onClickListener);
        squatStart.setOnClickListener(onClickListener);
        plankStart.setOnClickListener(onClickListener);
        legraiseStart.setOnClickListener(onClickListener);

    }

    protected void onClickExercise() {
    }
}