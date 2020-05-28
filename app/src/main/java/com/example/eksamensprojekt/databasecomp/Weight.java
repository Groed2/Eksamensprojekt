package com.example.eksamensprojekt.databasecomp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.jjoe64.graphview.series.DataPointInterface;

import java.util.Date;

@Entity(tableName = "Weight")
public class Weight implements DataPointInterface {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Date")
    public Date mDate;
    @ColumnInfo(name = "Weight")
    public Double mWeight;

    public Weight (Double mWeight)
    {
        long date = System.currentTimeMillis();
        this.mWeight = mWeight;
        this.mDate = new Date(date);
    }


    @Override
    public double getX() {
        return mDate.getTime();
    }

    @Override
    public double getY() {
        return mWeight;
    }
}
