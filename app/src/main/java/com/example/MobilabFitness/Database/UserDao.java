package com.example.MobilabFitness.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertOnlySingleMovie (User users);
    @Insert
    void insertMultipleUsers (List<User> usersList);

    @Query("SELECT * FROM users WHERE uid = :uid")
    User fetchOneUserbyUserId (int uid);

    @Query("SELECT * FROM users WHERE first_name = :first")
    User fetchUserbyUserName(String first);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users LIMIT 1")
    User getOneUser();

    @Query("SELECT COUNT(*) FROM users")
    int getUserCount();

    @Update
    void updateMovie (User users);

    @Delete
    void deleteMovie (User users);


}
