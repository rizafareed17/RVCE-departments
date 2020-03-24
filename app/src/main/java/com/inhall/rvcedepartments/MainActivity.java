package com.inhall.rvcedepartments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText emailId, password;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailId = findViewById(R.id.login_email_id);
        password = findViewById(R.id.login_password);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onLoginClicked(final View view) {
        if (emailId.getText().toString().equals("") || !Patterns.EMAIL_ADDRESS.matcher(emailId.getText().toString()).matches()){
            emailId.setError("Enter a valid email id");
            emailId.requestFocus();
            return;
        }

        if (password.getText().toString().equals("")){
            emailId.setError("Enter a valid enter your password");
            emailId.requestFocus();
            return;
        }

        emailId.setEnabled(false);
        password.setEnabled(false);
        view.setEnabled(false);
        emailId.setAlpha(0.5f);
        password.setAlpha(0.5f);
        view.setAlpha(0.8f);

        firebaseAuth.signInWithEmailAndPassword(emailId.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    emailId.setEnabled(true);
                    password.setEnabled(true);
                    view.setEnabled(true);
                    emailId.setAlpha(1f);
                    password.setAlpha(1f);
                    view.setAlpha(1f);
                }
            }
        });
    }
}
