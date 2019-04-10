package com.example.testproj5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Allscore extends AppCompatActivity {

    int S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allscore);
        S = getIntent().getIntExtra("Score", 0);
        TextView Sc = (TextView) findViewById(R.id.Score);
        Sc.setText("Votre Score " + S);
    }
}
