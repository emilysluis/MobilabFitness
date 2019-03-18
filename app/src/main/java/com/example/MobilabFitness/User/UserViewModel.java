package com.example.MobilabFitness.User;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * View Model to keep a reference to the user repository and
 * an up-to-date list of all users.
 */

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

//    private UserRepository mRepository;
//    // Using LiveData and caching what getAlphabetizedUsers returns has several benefits:
//    // - We can put an observer on the data (instead of polling for changes) and only update the
//    //   the UI when the data actually changes.
//    // - Repository is completely separated from the UI through the ViewModel.
//    private LiveData<List<User>> mAllUsers;
//
//    private LiveData<List<User.NameTuple>> mAllFullNames;
//
//    private LiveData<Integer> mRowCount;
//
//    private List<User> userData;
//
//    public UserViewModel(Application application) {
//        super(application);
//        mRepository = new UserRepository(application);
//        mAllUsers = mRepository.getAllUsers();
//        mAllFullNames = mRepository.loadFullNames();
//        mRowCount = mRepository.rowCount();
//        userData = mRepository.getAllUserData();
//    }
//
//
//    public List<User> getAllUserData() {
//        return userData;
//    }
//
//
//    public LiveData<List<User>> getAllUsers() {
//        return mAllUsers;
//    }
//
//    public LiveData<List<User.NameTuple>> loadFullNames() {
//        return mAllFullNames;
//    }
//
//    public LiveData<Integer> rowCount(){
//        return mRowCount;
//    }
//
//
//    public void insert(User user) {
//        mRepository.insert(user);
//    }
}

