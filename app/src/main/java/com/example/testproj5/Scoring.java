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

    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);

        TextView Score = (TextView) findViewById(R.id.score);
        TextView Hscore = (TextView) findViewById(R.id.Hscore);
        s = getIntent().getIntExtra("Score", 0);
        Score.setText(s + "");

        SharedPreferences sharedpreferences = getSharedPreferences("Save", Context.MODE_PRIVATE);
        int HS = sharedpreferences.getInt("Hscore", 0);

        if(s > HS)
        {
            Hscore.setText("High Score : " + s);

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("Hscore", s);
            editor.commit();
        }
        else
        {
            Hscore.setText("High Score : " + HS);
        }
    }
    public void Tryagain(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.testproj5.Start.class));
    }

    public void Save(View view)
    {
        Intent intent= new Intent(getApplicationContext(), SaveScore.class);
        intent.putExtra("Score", s);
        startActivity(intent);
    }
}
