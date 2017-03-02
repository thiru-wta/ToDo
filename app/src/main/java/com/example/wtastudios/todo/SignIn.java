package com.example.wtastudios.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void googleSignIn(View view) {
        startActivity(new Intent(getApplicationContext(),AddItemsToList.class));
    }

    public void mailSignIn(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }

    public void facebookSignIn(View view) {
    }

    public void directSignIn(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}
