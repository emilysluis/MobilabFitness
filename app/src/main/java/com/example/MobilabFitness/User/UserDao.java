package com.example.MobilabFitness.User;

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

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Update
    void updateMovie (User users);

    @Delete
    void deleteMovie (User users);

//    @Insert
//    void insertUser(User user);
//
//
//    @Query("SELECT * FROM users")
//    LiveData<List<User>> getAllUser();
//
////    @Query("SELECT * FROM users")
////    List<User> getAllUserData();
//
//
//    @Query("SELECT COUNT(*) FROM users")
//    LiveData<Integer> rowCount();
//
//    @Query("DELETE FROM users")
//    void deleteAll();
//
//    @Query("SELECT first_name, last_name FROM users")
//    LiveData<List<User.NameTuple>> loadFullNames();

//    @Query("SELECT first_name, last_name FROM users")
//    LiveData<List<User>> getAllUserNames(first_name);


}
