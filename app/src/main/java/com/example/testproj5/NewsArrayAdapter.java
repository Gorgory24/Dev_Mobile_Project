package com.example.testproj5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsArrayAdapter extends ArrayAdapter<LesScores> {

    private final Context context;

    public NewsArrayAdapter(Context context, ArrayList<LesScores> values) {
        super(context, R.layout.activity_textlist, values);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;

        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.activity_textlist, parent, false);
        }

        TextView NomTextView = (TextView) cellView.findViewById(R.id.Lejoueur);
        TextView ScoreTextView = (TextView) cellView.findViewById(R.id.Lescore);

        LesScores t = getItem(position);
        int p = t.getScore();
        NomTextView.setText(t.getNom());
        ScoreTextView.setText(" : " + String.valueOf(p));

        return cellView;
    }
}