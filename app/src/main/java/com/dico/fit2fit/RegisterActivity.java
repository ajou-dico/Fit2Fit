package com.dico.fit2fit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button nextBtn;
    EditText editEmail;
    EditText editPassword;
    EditText editNickname;
    EditText editHeight;
    EditText editWeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        nextBtn = findViewById(R.id.btn_create_account_next);
        nextBtn.setEnabled(false);

        editEmail = (EditText)findViewById(R.id.editTextEmail);
        editPassword = (EditText)findViewById(R.id.editTextPassword);
        editNickname = (EditText)findViewById(R.id.editTextNickname);
        editHeight = (EditText)findViewById(R.id.editTextHeight);
        editWeight = (EditText)findViewById(R.id.editTextGoalExerciseTime);

        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editNickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setNextBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                String nickname = editNickname.getText().toString();
                int height = Integer.parseInt(editHeight.getText().toString());
                int weight = Integer.parseInt(editWeight.getText().toString());

                Intent intent = new Intent(RegisterActivity.this, SettingGoalActivity.class);
                intent.putExtra("userEmail", email);
                intent.putExtra("userPassword", password);
                intent.putExtra("userNickname", nickname);
                intent.putExtra("userHeight", height);
                intent.putExtra("userWeight", weight);
                startActivity(intent);
            }
        });
    }

    protected void setNextBtnEnabled() {
        if((editEmail.getText().length() != 0) &&
                (editPassword.getText().length() != 0) &&
                (editNickname.getText().length() != 0) &&
                (editHeight.getText().length() != 0) &&
                (editWeight.getText().length() != 0)) {
            nextBtn.setEnabled(true);
        } else {
            nextBtn.setEnabled(false);
        }
    }

}
