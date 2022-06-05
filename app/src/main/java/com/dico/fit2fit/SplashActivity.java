package com.dico.fit2fit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Button logBtn;
    EditText emailEdit;
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_splash);

        logBtn = (Button)findViewById(R.id.btn_login);
        emailEdit = (EditText)findViewById(R.id.editTextEmail);
        passwordEdit = (EditText)findViewById(R.id.editTextPassword);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        logBtn.setEnabled(false);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "test");
            }
        });

        emailEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void setButtonEnabled() {
        if(emailEdit.getText().length() != 0 && passwordEdit.getText().length() != 0) {
            logBtn.setEnabled(true);
        } else {
            logBtn.setEnabled(false);
        }
    }
}
