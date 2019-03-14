package com.example.MobilabFitness.Workout;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "workout_table")
public class Workout {

    @PrimaryKey(autoGenerate = true)
    private int workoutid;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "duration")
    private int duration;

    @ColumnInfo(name = "distance")
    private int distance;

    @ColumnInfo(name = "calories")
    private int calories;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "energy_exp")
    private int energyExp;

    @NonNull
    @Override
    public String toString() {
        return workoutid + ": " + title;
    }

    public Workout(String title, String date, int duration, int distance, int calories, int type, int energyExp) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.calories = calories;
        this.type = type;
        this.energyExp = energyExp;
    }

    public int getWorkoutid() {
        return workoutid;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getDistance() {
        return distance;
    }

    public int getCalories() {
        return calories;
    }

    public int getType() {
        return type;
    }

    public int getEnergyExp() {
        return energyExp;
    }

    public void setWorkoutid(int workoutid) {
        this.workoutid = workoutid;
    }
}
