package com.example.testproj5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import static android.os.Build.VERSION_CODES.M;

public class Scoring extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);

        TextView Score = (TextView) findViewById(R.id.score);
        TextView Hscore = (TextView) findViewById(R.id.Hscore);

        int score = getIntent().getIntExtra("Score", 0);
        Score.setText(score + "");

        SharedPreferences sharedpreferences = getSharedPreferences("Save", Context.MODE_PRIVATE);
        int HS = sharedpreferences.getInt("Hscore", 0);

        if(score > HS)
        {
            Hscore.setText("High Score : " + score);

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("Hscore", score);
            editor.commit();
        }
        else
        {
            Hscore.setText("High Score : " + HS);
        }
    }
    public void Tryagain(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.testproj5.MainActivity.class));
    }
}
