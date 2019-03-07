package com.example.MobilabFitness.User;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * View Model to keep a reference to the user repository and
 * an up-to-date list of all users.
 */

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;
    // Using LiveData and caching what getAlphabetizedUsers returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<User>> mAllUsers;

    public UserViewModel(Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }
}

/*
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
*/
