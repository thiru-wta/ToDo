package com.example.wtastudios.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter exAdapter;
    List<String> listTitles;
    HashMap<String,List<String>> listDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getSupportActionBar().setTitle(null);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        expandableListView = (ExpandableListView) findViewById(R.id.expand_List);
        listDetails=GetListItems.getData();
        listTitles= new ArrayList<>(listDetails.keySet());
        exAdapter = new ListAdapter(this,listTitles,listDetails);
        expandableListView.setAdapter(exAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listTitles.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listTitles.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override

            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String title= listTitles.get(groupPosition);
                String item=listDetails.get(listTitles.get(groupPosition)).get(childPosition);
                if(title.equals("Cars")&&(item.equals("nano")||item.equals("A8")||item.equals("ciaz")||item.equals("verna"))){
//                    startActivity(new Intent(MainActivity.this,Cars.class));
                }
                openOptionsMenu();

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.copy) {
            return true;
        }
        if (id == R.id.view12) {
            return true;
        }
        if (id == R.id.setUpdate) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addEvent(View view) {
        openOptionsMenu();
    }
}
