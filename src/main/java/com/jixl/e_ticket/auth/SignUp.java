package com.jixl.e_ticket.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jixl.e_ticket.R;

import java.util.UUID;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    EditText emails,password;
    Button btnSignUp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        emails = (EditText) findViewById(R.id.edEmail);
        password = (EditText) findViewById(R.id.edPass);
        btnSignUp = (Button) findViewById(R.id.btnRegNow);



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String email = emails.getText().toString().trim();
                final String pwd = password.getText().toString().trim();
                if(email.isEmpty()){
                    emails.setError("Please enter email id");
                    emails.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignUp.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(!task.isSuccessful()){
                                Toast.makeText(SignUp.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                            else {
                                write(email,pwd);
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(email).build();

                                user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignUp.this, "username stored successful", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });



                                startActivity(new Intent(SignUp.this, Login.class));
                                Toast.makeText(SignUp.this, "Registration is successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUp.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void onClickBack(View view) {
        Intent ma = new Intent(this, MainPage.class);
        startActivity(ma);
        finish();
    }

    public void write(String email, String pass){
        User user = new User(email, "user");
        String userId = UUID.randomUUID().toString();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mRef = mDatabase.child("users/" + userId);
        mRef.setValue(user);
    }
}
