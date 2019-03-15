package com.example.MobilabFitness;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MobilabFitness.Workout.Workout;
import com.example.MobilabFitness.Workout.WorkoutViewModel;

import java.util.List;

public class WorkoutListFragment extends Fragment {

    private static final String TAG = "WorkoutListFragment";
    private WorkoutViewModel workoutViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.workout_list_fragment, container, false);

        workoutViewModel = ViewModelProviders.of(this).get(WorkoutViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewWorkout);
        final WorkoutListAdapter adapter = new WorkoutListAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        workoutViewModel.getAllWorkouts().observe(this, new Observer<List<Workout>>() {
            @Override
            public void onChanged(@Nullable List<Workout> workouts) {
                adapter.setmWorkouts(workouts);
            }
        });

        return view;
    }
}
