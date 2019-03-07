package com.example.MobilabFitness.User;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "users")
public class User {


    //TODO: add other attributes to constructor
    public User(@NonNull String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @PrimaryKey(autoGenerate = true)
    private int uid;

    @NonNull
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "birthday")
    private String Birthday;

    @ColumnInfo(name = "gender")
    private int Gender;

    @ColumnInfo(name = "height")
    private int Height;

    @ColumnInfo(name = "weight")
    private int Weight;

    @ColumnInfo(name = "functional_level")
    private int FunctionalLevel;


    public int getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getFunctionalLevel() {
        return FunctionalLevel;
    }

    public void setFunctionalLevel(int functionalLevel) {
        FunctionalLevel = functionalLevel;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
