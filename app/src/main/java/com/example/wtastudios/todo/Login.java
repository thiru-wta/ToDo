package com.example.wtastudios.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Database db;
    private EditText ed_email;
    private EditText ed_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email = (EditText) findViewById(R.id.loginEmail);
        ed_password = (EditText) findViewById(R.id.login_password);
    }

    public void onLogin(View view) {
        String email = ed_email.getText().toString();
        String password = ed_password.getText().toString();
        int count=0;
        count = db.validateData(email,password);
        if(count>0){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

    }
}
