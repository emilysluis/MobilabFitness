package com.example.MobilabFitness.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "userId")


@Entity(tableName = "workout_table")


public class Workout {

    @PrimaryKey(autoGenerate = true)
    private int workoutid;

    @ColumnInfo(name = "userId")
    private int userId;

    @ColumnInfo(name = "title")
    private String title;

    @Embedded
    private date Date;

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

    public String workoutDetails() {
        return  duration + " mins - "
                + distance + " km  - " + calories + " Cal\n";
    }


    public Workout(String title, int userId, int duration, int distance, int calories, int type, int energyExp, date Date) {
        this.title = title;
        this.userId = userId;
        this.duration = duration;
        this.distance = distance;
        this.calories = calories;
        this.type = type;
        this.energyExp = energyExp;
        this.Date = Date;
    }

    public int getWorkoutid() {
        return workoutid;
    }

    public String getTitle(){
        return title;
    }

    public date getDate(){
        return Date;
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

    void setWorkoutid(int workoutid) {
        this.workoutid = workoutid;
    }

    public void setDate(com.example.MobilabFitness.Database.date Date) {
        this.Date = Date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }


}

