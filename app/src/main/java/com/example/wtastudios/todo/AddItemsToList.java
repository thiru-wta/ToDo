package com.example.wtastudios.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddItemsToList extends AppCompatActivity {

    TextView welcomeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items_to_list);
        welcomeText = (TextView)findViewById(R.id.welcomeUser);
        String user_name = getIntent().getStringExtra("username");
        welcomeText.setText("Hi "+user_name+", \nWelcome to To.Do");
    }

    public void addFirstItem(View view) {
        startActivity(new Intent(AddItemsToList.this,SearchITemActivity.class));
        view.setVisibility(View.GONE);
    }
}
