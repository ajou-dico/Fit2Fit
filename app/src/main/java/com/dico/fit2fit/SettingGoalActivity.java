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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SettingGoalActivity extends AppCompatActivity {

    private static final String TAG = "Tag";
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    Button nextFinishBtn;

    EditText editGoalWeight;
    EditText editGoalExerciseTime;

    String email;
    int goalExerciseTime;
    int goalWeight;
    String password;
    String goalDate;
    String nickname;
    int height;
    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_goal);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editGoalWeight = (EditText)findViewById(R.id.editTextGoalWeight);
        editGoalExerciseTime = (EditText)findViewById(R.id.editTextGoalExerciseTime);
        nextFinishBtn = (Button)findViewById(R.id.btn_setting_goal);
        nextFinishBtn.setEnabled(false);

        Intent intent = getIntent();
        email = intent.getStringExtra("userEmail");
        /*
        goalWeight = Integer.parseInt(editGoalWeight.getText().toString());
        goalExerciseTime = Integer.parseInt(editGoalExerciseTime.getText().toString());
        */
        password = intent.getStringExtra("userPassword");
        nickname = intent.getStringExtra("userNickname");
        height = intent.getIntExtra("userHeight", 0);
        weight = intent.getIntExtra("userWeight", 0);

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
        editGoalWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextFinishBtn();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                goalWeight = Integer.parseInt(editGoalWeight.getText().toString());
            }
        });
        editGoalExerciseTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextFinishBtn();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                goalExerciseTime = Integer.parseInt(editGoalExerciseTime.getText().toString());
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
                            setUserInfo();
                            Intent intent = new Intent(SettingGoalActivity.this, completeRegisterActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SettingGoalActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void setNextFinishBtn() {
        if (editGoalWeight.getText().length() != 0 && editGoalExerciseTime.getText().length() != 0) {
            nextFinishBtn.setEnabled(true);
        } else {
            nextFinishBtn.setEnabled(false);
        }
    }

    protected void setUserInfo() {
// Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        userInfo usrInf = new userInfo(email, goalDate, goalExerciseTime, goalWeight, height, nickname, weight);
        user.put("profile", usrInf);

// Add a new document with a generated ID
        db.collection("Users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}