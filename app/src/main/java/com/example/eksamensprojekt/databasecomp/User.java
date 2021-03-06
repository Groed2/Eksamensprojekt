package com.example.eksamensprojekt.databasecomp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserId")
    public int uId;
    @ColumnInfo(name = "InitialWeight")
    public double mInitWeight;
    @ColumnInfo(name = "Height")
    public double mHeight;

    public User(double mInitWeight, double mHeight)
    {
        this.mInitWeight = mInitWeight;
        this.mHeight = mHeight;
    }
    
}
