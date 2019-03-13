package com.example.MobilabFitness.Workout;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WorkoutRepository {

    private WorkoutDao mWorkoutDao;
    private LiveData<List<Workout>> mAllWorkouts;

    WorkoutRepository(Application application) {
        WorkoutRoomDatabase db = WorkoutRoomDatabase.getDatabase(application);
        mWorkoutDao = db.workoutDao();
        mAllWorkouts = mWorkoutDao.getAllWorkouts();
    }

    LiveData<List<Workout>> getAllWorkouts() {
        return mAllWorkouts;
    }


    public void insert (Workout workout) {
        new insertAsyncTask(mWorkoutDao).execute(workout);
    }

    private static class insertAsyncTask extends AsyncTask<Workout, Void, Void> {

        private WorkoutDao mAsyncTaskDao;

        insertAsyncTask(WorkoutDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Workout... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
