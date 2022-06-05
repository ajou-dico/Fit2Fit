package com.dico.fit2fit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {

    Button logBtn;
    EditText emailEdit;
    EditText passwordEdit;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_splash);

        logBtn = (Button)findViewById(R.id.btn_login);
        emailEdit = (EditText)findViewById(R.id.editTextEmail);
        passwordEdit = (EditText)findViewById(R.id.editTextPassword);

        logBtn.setEnabled(false);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                signIn(email, password);
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

    public void onClickRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(SplashActivity.this, "회원 정보가 일치하지 않습니다.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
