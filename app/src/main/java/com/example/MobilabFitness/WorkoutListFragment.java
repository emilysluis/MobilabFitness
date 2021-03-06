package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.appDatabase;

import java.util.List;

public class WorkoutListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";

    private appDatabase userDatabase;
    private static final String DATABASE_NAME = "app_db";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        userDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();


        View view = inflater.inflate(R.layout.workout_list_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewWorkout);
        final WorkoutListAdapter adapter = new WorkoutListAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Workout> listOfWorkouts = userDatabase.workoutDao().getAllWorkouts();
                adapter.setWorkouts(listOfWorkouts);
            }
        }) .start();

        return view;
    }
}
