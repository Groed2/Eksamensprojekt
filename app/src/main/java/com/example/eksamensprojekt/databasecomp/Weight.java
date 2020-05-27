package com.example.eksamensprojekt.databasecomp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Weight")
public class Weight {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Date")
    public Date mDate;
    @ColumnInfo(name = "Weight")
    public Double mWeight;


}
