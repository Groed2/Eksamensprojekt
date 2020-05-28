package com.example.eksamensprojekt.databasecomp;

import androidx.room.TypeConverter;

import java.util.Date;

public class TypeConverterClass {
    @TypeConverter
    public static Date toDate(Long dateLong)
    {
        return dateLong == null ? null: new Date(dateLong);
    }
    @TypeConverter
    public static Long fromDate(Date longDate)
    {
        return longDate == null ? null: longDate.getTime();
    }
}
