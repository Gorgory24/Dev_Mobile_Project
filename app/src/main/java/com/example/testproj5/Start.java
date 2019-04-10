package com.example.testproj5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void Commence(View view)
    {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void Scoring(View view)
    {
        startActivity(new Intent(getApplicationContext(), AllScore.class));
    }
}
