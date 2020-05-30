package com.example.eksamensprojekt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eksamensprojekt.databasecomp.Activity;
import com.example.eksamensprojekt.databasecomp.AppDatabase;
import com.example.eksamensprojekt.databasecomp.Weight;
import com.example.eksamensprojekt.databasecomp.User;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
private AppDatabase db;
private Weight[] mWeights;
private User[] mUsers;
private Activity[] mActivity;
    private String text;
    //text for text objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Links our Graphview to the XML object
        GraphView graph = findViewById(R.id.Graph);

        //Layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        db = AppDatabase.getAppDatabase(this);
        if(db.activityDao().countWeights() == 0) {
            Weight weight = new Weight(86.0);
            db.activityDao().insert(weight);
            weight = new Weight(85.0);
            db.activityDao().insert(weight);
            User user = new User(82.2, 179);
            db.activityDao().insert(user);
            mWeights = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();
            mActivity = db.activityDao().loadAllActivities();
        }




        //Buttons and text objects
        TextView lastAct = findViewById(R.id.activityanswer);
        TextView initWeight = findViewById(R.id.startweightanswer);
        TextView initBMI = findViewById(R.id.BMIanswer);
        TextView WeightLoss = findViewById(R.id.weightlostanswer);
        TextView CurrBMI = findViewById(R.id.BMITextField);
        TextView currWeight = findViewById(R.id.weekTextview);
        Button buttonBack = findViewById(R.id.button9);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (mWeights.length != null)
        text = mWeights[mWeights.length-1].mWeight.toString();
        currWeight.setText(text);







    }
    LineGraphSeries<Weight> series = new LineGraphSeries<Weight>(new Weight[] {
            new Weight(86.0),
            new Weight(85.0),
            new Weight(84.0)
    });



}
