package com.example.testproj5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveScore extends AppCompatActivity {

    int S;
    EditText pseudo;
    String name;
    String Seditor;
    //SharedPreferences ListScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savescore);
        S = getIntent().getIntExtra("Score", 0);
        //ListScore = getSharedPreferences("ListScore", Context.MODE_PRIVATE);
        //Seditor = String.valueOf(S);
        pseudo = (EditText) findViewById(R.id.pseudo);
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, clef);
        //list = (ListView) findViewById(R.id.list);
        //list.setAdapter(adapter);
    }

    public void Valid(View view)
    {
        name = pseudo.getText().toString();
        Intent intent = new Intent(getApplicationContext(), AllScore.class);
        intent.putExtra("Score", S);
        intent.putExtra("Name", name);
        startActivity(intent);
    }
}
