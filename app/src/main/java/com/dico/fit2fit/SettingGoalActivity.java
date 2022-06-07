package com.dico.fit2fit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class SettingGoalActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Button nextFinishBtn;
    EditText goalWeight;
    EditText gaolExerciseTime;
    String goalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_goal);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        goalWeight = (EditText)findViewById(R.id.editTextGoalWeight);
        gaolExerciseTime = (EditText)findViewById(R.id.editTextGoalExerciseTime);
        nextFinishBtn = (Button)findViewById(R.id.btn_setting_goal);
        nextFinishBtn.setEnabled(false);

        Intent intent = getIntent();
        String email = intent.getStringExtra("userEmail");
        String password = intent.getStringExtra("userPassword");
        String nickname = intent.getStringExtra("userNickname");
        int height = intent.getIntExtra("userHeight", 0);
        int weight = intent.getIntExtra("userWeight", 0);

        CalendarView cal = (CalendarView)findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String month;
                if (i1+1 < 10) {
                    month = "0" + String.valueOf(i1+1);
                } else {
                    month = String.valueOf(i1+1);
                }
                goalDate = (String.valueOf(i) + "/" + month + "/" + String.valueOf(i2));
            }
        });
        goalWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextFinishBtn();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        gaolExerciseTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextFinishBtn();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nextFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount(email, password);
            }
        });
    }

    protected void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SettingGoalActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }

    private void setNextFinishBtn() {
        if (goalWeight.getText().length() != 0 && gaolExerciseTime.getText().length() != 0) {
            nextFinishBtn.setEnabled(true);
        } else {
            nextFinishBtn.setEnabled(false);
        }
    }
}