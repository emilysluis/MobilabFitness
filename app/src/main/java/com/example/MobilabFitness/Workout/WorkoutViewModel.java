package com.example.MobilabFitness.Workout;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {
    private WorkoutRepository mRepository;

    private LiveData<List<Workout>> mAllWorkouts;

    public WorkoutViewModel (Application application) {
        super(application);
        mRepository = new WorkoutRepository(application);
        mAllWorkouts = mRepository.getAllWorkouts();
    }

    public LiveData<List<Workout>> getAllWorkouts() { return mAllWorkouts; }

    public void insert(Workout workout) { mRepository.insert(workout); }
}
