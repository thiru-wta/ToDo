package com.example.wtastudios.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstListItem extends AppCompatActivity {
    RecyclerView listView;
    ArrayList<GetDetailList> show = new ArrayList<GetDetailList>();;
    Database db;
    FirstItemAdapter add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list_item);
        listView = (RecyclerView) findViewById(R.id.firstEventList);
        //Bundle get = getIntent().getExtras();
        show = db.getListItem();
        add= new FirstItemAdapter(this,show);
        db = new Database(this);
        listView.setAdapter(add);
    }
}
