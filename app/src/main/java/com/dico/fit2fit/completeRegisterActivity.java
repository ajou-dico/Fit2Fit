package com.dico.fit2fit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class completeRegisterActivity extends AppCompatActivity {

    Button completeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_register);

        completeBtn = (Button)findViewById(R.id.btn_complete);
        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(completeRegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}