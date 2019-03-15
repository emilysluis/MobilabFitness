package com.example.MobilabFitness.Workout;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Workout.class}, version = 1)
public abstract class WorkoutRoomDatabase extends RoomDatabase {
    public abstract WorkoutDao workoutDao();

    private static volatile WorkoutRoomDatabase INSTANCE;

    static WorkoutRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WorkoutRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WorkoutRoomDatabase.class, "workout_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new WorkoutRoomDatabase.PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WorkoutDao mDao;

        PopulateDbAsync(WorkoutRoomDatabase db) {
            mDao = db.workoutDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
            Workout workout = new Workout("Sample", "01/01/2019", 5, 5, 1, 1, 1);
            mDao.insert(workout);
            return null;
        }
    }
}
