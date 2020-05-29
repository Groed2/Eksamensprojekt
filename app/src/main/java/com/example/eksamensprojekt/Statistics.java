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

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
private AppDatabase db;
private Weight[] mWeights;
private User[] mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GraphView graph = findViewById(R.id.Graph);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        db = AppDatabase.getAppDatabase(this);
        if(db.activityDao().countWeights() == 0){
            Weight weight = new Weight( 86.0);
            db.activityDao().insert(weight);
            weight = new Weight(85.0);
            db.activityDao().insert(weight);
            mWeights = db.activityDao().loadAllWeightElements();

        }
     else {
            mWeights = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();

        }

        LineGraphSeries<Weight> series = new LineGraphSeries<Weight>(new Weight[] {
                new Weight(86.0),
                new Weight(85.0),
                new Weight(84.0)
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
