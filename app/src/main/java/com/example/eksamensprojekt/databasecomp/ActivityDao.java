package com.example.eksamensprojekt.databasecomp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ActivityDao {

    @Query("SELECT * FROM activity where activityDone = 0")
    public Activity[] loadAllActivities();

    @Query("UPDATE activity SET activityDone = 1 WHERE uid = :uid")
    int updateActivityDone(int uid);

    @Query("SELECT * FROM Weight")
    public Weight[] loadAllWeightElements();

    @Query("SELECT * FROM User")
    public User[] loadAllUsers();

    @Query("SELECT * FROM Weight WHERE Date BETWEEN :startDate AND :endDate")
    public Weight[] loadAllWeightBetweenDates(int startDate, int endDate);
    @Update
    int update(Activity activity);

    @Update
    void update(Weight weight);

    @Update
    void  update(User user);

    @Insert
    void insert(Weight weight);

    @Insert
    void insert(User user);

    @Insert
    void insert(Activity activity);

    @Query("SELECT COUNT(*) from activity")
    int countActivities();

    @Query("SELECT COUNT(*) from Weight")
    int countWeights();

    @Query("SELECT COUNT(*) FROM USER")
    int countUsers();

    @Query("SELECT * FROM activity WHERE uid BETWEEN :startDate AND :endDate")
    public Activity[] loadAllActivitiesBetweenDates(int startDate, int endDate);



}
