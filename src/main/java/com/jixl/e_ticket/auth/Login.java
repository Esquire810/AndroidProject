package com.jixl.e_ticket.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.jixl.e_ticket.NawActivity;
import com.jixl.e_ticket.R;

public class Login extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgress;
    EditText edEmail, edPass;
    Button btLogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        btLogIn = findViewById(R.id.onClickLogIn);

        mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, NawActivity.class));
            finish();
        }

        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edEmail.getText().toString().trim();
                final String pwd = edPass.getText().toString().trim();
                if (email.isEmpty()) {
                    edEmail.setError("Please enter email");
                    edEmail.requestFocus();
                } else if (pwd.isEmpty()) {
                    edPass.setError("Please enter your password");
                    edPass.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Login.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mProgress.show();
                    mProgress.dismiss();
                    firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(Login.this, NawActivity.class));
                                finish();
                            } else {
                                Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void onClickBack(View view) {
        Intent ma = new Intent(this, MainPage.class);
        startActivity(ma);
        finish();
    }
}
