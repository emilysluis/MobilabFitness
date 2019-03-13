package com.example.MobilabFitness.User;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);


    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT COUNT(*) FROM users")
    LiveData<Integer> rowCount();

    @Query("DELETE FROM users")
    void deleteAll();

    @Query("SELECT first_name, last_name FROM users")
    LiveData<List<User.NameTuple>> loadFullNames();

//    @Query("SELECT first_name, last_name FROM users")
//    LiveData<List<User>> getAllUserNames(first_name);


}
