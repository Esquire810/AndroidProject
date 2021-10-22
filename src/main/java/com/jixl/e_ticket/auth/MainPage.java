package com.jixl.e_ticket.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.jixl.e_ticket.R;
import com.jixl.e_ticket.auth.Login;
import com.jixl.e_ticket.auth.SignUp;


public class MainPage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogIn(View view) {
        Intent login = new Intent(this, Login.class);
        startActivity(login);
        finish();
    }

    public void onClickReg(View view) {
        Intent reg = new Intent(this, SignUp.class);
        startActivity(reg);
        finish();
    }
}
        