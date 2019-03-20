package com.example.MobilabFitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MobilabFitness.Database.Workout;

import java.util.Collections;
import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.WorkoutViewHolder> {



    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView summary;
        private final TextView energyLevel;


        WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            summary = itemView.findViewById(R.id.textViewSummary);
            energyLevel = itemView.findViewById(R.id.textViewEnergy);

        }
    }

    private final LayoutInflater mInflater;
    private List<Workout> mWorkouts = Collections.emptyList();

    private ViewGroup viewGroup;

    WorkoutListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.recyclerview_workout_item,
                viewGroup, false);
        this.viewGroup = viewGroup;
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int i) {
        Workout current = mWorkouts.get(i);
        workoutViewHolder.energyLevel.setText(Integer.toString(current.getEnergyExp()));



        int energy = current.getEnergyExp();
        switch (energy){
            case 1:
            case 2:
            case 3:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.colorPrimary));
        }

        workoutViewHolder.title.setText(current.getTitle());
        workoutViewHolder.summary.setText(current.workoutDetails());
    }

    void setWorkouts(List<Workout> mWorkouts) {
        this.mWorkouts = mWorkouts;
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWorkouts.size();
    }


}
