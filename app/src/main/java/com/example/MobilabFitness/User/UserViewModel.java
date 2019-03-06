package com.example.MobilabFitness.User;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel {
    private UserRepository mRepository;

    private LiveData<List<User>> mAllUsers;

    public UserViewModel (Application application) {
        //TODO: uncomment line below
        //  super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() { return mAllUsers; }

    public void insert(User user) { mRepository.insert(user); }
}
