package com.dico.fit2fit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_splash);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button logBtn = (Button)findViewById(R.id.btn_login);
        EditText emailEdit = (EditText) findViewById(R.id.editTextEmail);
        EditText passwordEdit = (EditText) findViewById(R.id.editTextPassword);

        if((emailEdit.getText().length() != 0) && (passwordEdit.getText().length() != 0)) {
            logBtn.setEnabled(true);
        } else {
            logBtn.setEnabled(false);
        }
    }
}
