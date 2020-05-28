package com.example.eksamensprojekt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eksamensprojekt.databasecomp.AppDatabase;
import com.example.eksamensprojekt.databasecomp.Weight;
import com.example.eksamensprojekt.databasecomp.User;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Statistics extends AppCompatActivity {
private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GraphView graph = (GraphView) findViewById(R.id.StatGraph);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        db = AppDatabase.getAppDatabase(this);
        db.activityDao().
        LineGraphSeries<Weight> series = new LineGraphSeries<Weight>(new Weight[] {

        });


        Button buttonBack = findViewById(R.id.button9);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
