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

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
private AppDatabase db;
private Weight[] mWeights;
private User[] mUsers;
private Activity[] mActivity;
    private String text;
    private DecimalFormat numberFormat = new DecimalFormat("#.000");
    //text for text objects

    // fix this shit tomoz,
    LineGraphSeries<Weight> series = new LineGraphSeries<Weight>();


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
            User user = new User(82.2, 1.79);
            db.activityDao().insert(user);
            mWeights = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();
            mActivity = db.activityDao().loadAllActivities();
        }
        else {
            mWeights = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();
            mActivity = db.activityDao().loadAllActivities();
        }

        graph.addSeries(series);




        //Buttons and text objects

        //show last activity
        TextView lastAct = findViewById(R.id.activityanswer);
        //shows initial weight
        TextView initWeight = findViewById(R.id.startweightanswer);
        text = String.valueOf(mUsers[mUsers.length-1].mInitWeight);
        initWeight.setText(text);
        // shows initial BMI
        TextView initBMI = findViewById(R.id.startBMIanswer);
        text = String.valueOf(numberFormat.format(mUsers[mUsers.length-1].mInitWeight / (mUsers[mUsers.length-1].mHeight * mUsers[mUsers.length-1].mHeight)));
        initBMI.setText(text);
        //shows total weight loss from start
        TextView WeightLoss = findViewById(R.id.weightlostanswer);
        text = String.valueOf(numberFormat.format(mUsers[mUsers.length-1].mInitWeight - mWeights[mWeights.length-1].mWeight));
        WeightLoss.setText(text);
        //shows current BMI
        TextView CurrBMI = findViewById(R.id.BMIanswer);
        text = String.valueOf(numberFormat.format(mWeights[mWeights.length-1].mWeight / (mUsers[mUsers.length-1].mHeight * mUsers[mUsers.length-1].mHeight)));
        CurrBMI.setText(text);
        //shows current weight
        TextView currWeight = findViewById(R.id.WeightShowCurrent);
        text = mWeights[mWeights.length-1].mWeight.toString();
        currWeight.setText(text);

        Button buttonBack = findViewById(R.id.button9);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });








    }




}
