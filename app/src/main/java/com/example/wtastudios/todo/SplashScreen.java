package com.example.wtastudios.todo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
private  static int SPLASH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(SPLASH_TIME_OUT);
                    Intent in=new Intent(getApplicationContext(), SignIn.class);
                    startActivity(in);
                    finish();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }

        };

        thread.start();
    }
}

