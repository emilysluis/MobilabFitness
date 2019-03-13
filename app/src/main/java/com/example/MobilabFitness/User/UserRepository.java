package com.example.MobilabFitness.User;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;
    private LiveData<List<User.NameTuple>> mAllFullNames;
    private LiveData<Integer> mRowCount;

    UserRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUsers = mUserDao.getAllUsers();
        mAllFullNames = mUserDao.loadFullNames();
        mRowCount = mUserDao.rowCount();
    }

    LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }
    LiveData<List<User.NameTuple>> loadFullNames() {
        return mAllFullNames;
    }

    LiveData<Integer> rowCount(){
        return mRowCount;
    }





    public void insert (User user) {
        new insertAsyncTask(mUserDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertUser(params[0]);
            return null;
        }
    }
}
