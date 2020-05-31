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
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
private AppDatabase db;
private Weight[] mWeight = new Weight[]{
        new Weight(90.0),
        new Weight( 89.0),
        new Weight( 88.0),
        new Weight(87.0)
    };
private User[] mUsers;
private Activity[] mActivity;
    private String text;
    private DecimalFormat numberFormat = new DecimalFormat("#.000");
    //text for text objects

    // fix this shit tomoz,
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
            new DataPoint(mWeight[0].getX(),mWeight[0].getY()),
            new DataPoint(mWeight[1].getX(),mWeight[1].getY()),
            new DataPoint(mWeight[2].getX(),mWeight[2].getY()),
            new DataPoint(mWeight[3].getX(),mWeight[3].getY())
                });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        //Links our Graphview to the XML object
        GraphView graph = findViewById(R.id.Graph);
        graph.addSeries(series);

        //Layout
        db = AppDatabase.getAppDatabase(this);
        if(db.activityDao().countWeights() == 0) {
            Weight weight = new Weight(86.0);
            db.activityDao().insert(weight);
            weight = new Weight(85.0);
            db.activityDao().insert(weight);
            User user = new User(82.2, 1.79);
            db.activityDao().insert(user);
            mWeight = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();
            mActivity = db.activityDao().loadAllActivities();
        }
        else {
            mWeight = db.activityDao().loadAllWeightElements();
            mUsers = db.activityDao().loadAllUsers();
            mActivity = db.activityDao().loadAllActivities();
        }


//rendering x axis as dates
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space
//cropping size to the values of the series for x values
        graph.getViewport().setMinX(series.getLowestValueX());
        graph.getViewport().setMaxX(series.getHighestValueX());
        graph.getViewport().setXAxisBoundsManual(true);
//cropping size to the values of the series for y values
        graph.getViewport().setMaxY(series.getHighestValueY());

        graph.getViewport().setMinY(series.getLowestValueY());
        graph.getViewport().setYAxisBoundsManual(true);






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
        text = String.valueOf(numberFormat.format(mUsers[mUsers.length-1].mInitWeight - mWeight[mWeight.length-1].mWeight));
        WeightLoss.setText(text);
        //shows current BMI
        TextView CurrBMI = findViewById(R.id.BMIanswer);
        text = String.valueOf(numberFormat.format(mWeight[mWeight.length-1].mWeight / (mUsers[mUsers.length-1].mHeight * mUsers[mUsers.length-1].mHeight)));
        CurrBMI.setText(text);
        //shows current weight
        TextView currWeight = findViewById(R.id.WeightShowCurrent);
        text = mWeight[mWeight.length-1].mWeight.toString();
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
