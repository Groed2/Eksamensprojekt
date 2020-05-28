package com.example.eksamensprojekt.databasecomp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Activity.class,Weight.class,User.class}, version = 1, exportSchema = false)
@TypeConverters({TypeConverterClass.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract ActivityDao activityDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "activity-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
}
