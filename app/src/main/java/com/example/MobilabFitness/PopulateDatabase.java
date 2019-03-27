//package com.example.MobilabFitness;
//
//import android.arch.persistence.room.Room;
//import android.content.Context;
//
//import com.example.MobilabFitness.Database.User;
//
//public class PopulateDatabase {
//
//    private static final String DATABASE_NAME = "app_db";
//    private com.example.MobilabFitness.Database.appDatabase appDatabase;
//
//    public void PopulateDatabase(Context context){
//
//        appDatabase = Room.databaseBuilder(context, com.example.MobilabFitness.Database.appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
//                .build();
//
//        final User user1 = new User("FirstName", "LastName", "01/01/2000", 1, 160, 60, 1);
//        final User user2 = new User("Mickey", "Mouse", "18/11/1928", 1, 96, 10, 2);
//        final User user3 = new User("Chester", "TheCat", "15/05/2008", 1, 50, 5, 3);
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                appDatabase.userDao().insertOnlySingleMovie(user1);
//                appDatabase.userDao().insertOnlySingleMovie(user2);
//                appDatabase.userDao().insertOnlySingleMovie(user3);
//
//            }
//        }) .start();
//    }
//
//
//}
