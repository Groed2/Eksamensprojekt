package com.example.eksamensprojekt.databasecomp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "UserId")
    public int uId;
    @ColumnInfo(name = "InitialWeight")
    public double mInitWeight;
    @ColumnInfo(name = "Height")
    public int mHeight;
    
}
