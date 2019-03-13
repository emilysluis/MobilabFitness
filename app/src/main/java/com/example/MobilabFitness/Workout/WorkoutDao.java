package com.example.MobilabFitness.Workout;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkoutDao {

    @Insert
    void insert(Workout workout);

    @Query("SELECT * FROM workout_table")
    LiveData<List<Workout>> getAllWorkouts();

    @Delete
     void deleteWorkout(Workout workout);

    @Query("DELETE FROM workout_table")
    void deleteAll();


}
