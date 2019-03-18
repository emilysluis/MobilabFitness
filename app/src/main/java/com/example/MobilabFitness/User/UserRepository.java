package com.example.MobilabFitness.User;

public class UserRepository {


//    private UserDao mUserDao;
//    private LiveData<List<User>> mAllUsers;
//    private LiveData<List<User.NameTuple>> mAllFullNames;
//    private LiveData<Integer> mRowCount;
//    private List<User> userData;
//
//    UserRepository(Application application) {
//        appDatabase db = appDatabase.getDatabase(application);
//        mUserDao = db.userDao();
//        mAllUsers = mUserDao.getAllUsers();
//        mAllFullNames = mUserDao.loadFullNames();
//        mRowCount = mUserDao.rowCount();
//        userData = mUserDao.getAllUserData();
//    }
//
//    LiveData<List<User>> getAllUsers() {
//        return mAllUsers;
//    }
//
//    List<User> getAllUserData() {
//        return userData;
//    }
//
//    LiveData<List<User.NameTuple>> loadFullNames() {
//        return mAllFullNames;
//    }
//
//    LiveData<Integer> rowCount(){
//        return mRowCount;
//    }
//
//
//
//
//
//    public void insert (User user) {
//        new insertAsyncTask(mUserDao).execute(user);
//    }
//
//    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
//
//        private UserDao mAsyncTaskDao;
//
//        insertAsyncTask(UserDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final User... params) {
//            mAsyncTaskDao.insertUser(params[0]);
//            return null;
//        }
//    }
}
