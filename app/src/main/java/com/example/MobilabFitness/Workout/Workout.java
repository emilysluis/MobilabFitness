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
            return workoutid + ": " + title + "\n"
                    + "duration: " + duration + "mins\n"
                    + "distance: " + distance + "km\n"
                    + "calories: " + calories
                    + "\ntype: " + type
                    + "\nEnergy Expenditure: " + energyExp;
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

    int getWorkoutid() {
        return workoutid;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    int getDuration() {
        return duration;
    }

    int getDistance() {
        return distance;
    }

    int getCalories() {
        return calories;
    }

    int getType() {
        return type;
    }

    int getEnergyExp() {
        return energyExp;
    }

    void setWorkoutid(int workoutid) {
        this.workoutid = workoutid;
    }
}
