package com.example.wtastudios.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchITemActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String KEY_ITEM = "listItem";
    ImageButton btnSpeak;
    TextView add_item_to_list;
    EditText search_item;
    Database db;
    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        add_item_to_list = (TextView) findViewById(R.id.add_item_first);
        add_item_to_list.setOnClickListener(this);
        search_item = (EditText)findViewById(R.id.edt_search_input);
        item = search_item.getText().toString();
        db = new Database(this);

    }


    @Override
    public void onClick(View view) {

        db.setFirstItemToList(item);
        Intent intent = new Intent(getApplicationContext(),FirstListItem.class);
        startActivity(intent);

    }

}
