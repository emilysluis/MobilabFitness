package com.example.MobilabFitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MobilabFitness.Workout.Workout;

import java.util.Collections;
import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.WorkoutViewHolder> {



    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView summary;
        WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            summary = itemView.findViewById(R.id.textViewSummary);
        }
    }

    private final LayoutInflater mInflater;
    private List<Workout> mWorkouts = Collections.emptyList();

    WorkoutListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.recyclerview_workout_item,
                viewGroup, false);
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int i) {
        Workout current = mWorkouts.get(i);
        workoutViewHolder.title.setText(current.getTitle());
        workoutViewHolder.summary.setText(current.toString());
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
