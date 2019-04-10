package com.example.testproj5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllScore extends AppCompatActivity {

    ListView LesScores;
    int NewScore;
    String Name;
    //ArrayList<String> clef = new ArrayList<String>();
    //ArrayAdapter<String> adapter;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_score);
        LesScores = (ListView) findViewById(R.id.list);
        // A METTRE DANS UN IF
        //NewScore = getIntent().getIntExtra("Score", 0);
        //Name = getIntent().getStringExtra("Name");
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, clef);
        //list.setAdapter(adapter);
    }
}
