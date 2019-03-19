package com.example.MobilabFitness.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "users")
public class User {

    //TODO: add other attributes to constructor
    public User(@NonNull String firstName,  String lastName, String birthday,
                int gender, int height, int weight, int funcLevel){

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.funcLevel = funcLevel;

    }

    @NonNull
    @Override
    public String toString() {
        return uid + ": " + firstName + " " + lastName;
    }

    public static class NameTuple {

        @ColumnInfo(name="first_name")
        public String firstName;

        @ColumnInfo(name="last_name")
        public String lastName;

        @NonNull
        @Override
        public String toString() {
            return firstName + lastName;
        }
    }


    @PrimaryKey(autoGenerate = true)
    private int uid;

    @NonNull
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "birthday")
    private String birthday;

    @ColumnInfo(name = "gender")
    private int gender;

    @ColumnInfo(name = "height")
    private int height;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "functional_level")
    private int funcLevel;


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
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFuncLevel() {
        return funcLevel;
    }

    public void setFuncLevel(int funcLevel) {
        this.funcLevel = funcLevel;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


}


