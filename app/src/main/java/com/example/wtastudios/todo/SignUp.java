package com.example.wtastudios.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText ed_name;
    private EditText ed_email;
    private EditText ed_password;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new Database(this);
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_email = (EditText) findViewById(R.id.ed_email);
        ed_password = (EditText) findViewById(R.id.ed_password);
    }

    public void signUp(View view) {
        String name = ed_name.getText().toString();
        String email = ed_email.getText().toString();
        String password = ed_password.getText().toString();

        boolean isValid = true;

        if (TextUtils.isEmpty(name)) {
            ed_name.setError(getString(R.string.error_invalid_name));
            isValid = false;
        }

        if (TextUtils.isEmpty(email)) {
            ed_email.setError(getString(R.string.error_invalid_email));
            isValid = false;
        }

        if (TextUtils.isEmpty(password) || password.length() < 7) {
            ed_password.setError(getString(R.string.error_invalid_password));
            isValid = false;
        }

        if (isValid) {
            db.regData(name, email, password);
//            SignIn.startSignIn(this, name, email);
            Intent intent = new Intent(getApplicationContext(),AddItemsToList.class);
            intent.putExtra("username",name);
            startActivity(intent);
        }
    }
}