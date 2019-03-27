package com.example.MobilabFitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.date;

import java.util.Collections;
import java.util.List;


public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.WorkoutViewHolder> {

    String TAG = "WorkoutListAdapter";


    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView summary;
        private final TextView energyLevel;
        private final TextView activityType;
        private final TextView day;
        private final TextView month;


        WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            summary = itemView.findViewById(R.id.textViewSummary);
            energyLevel = itemView.findViewById(R.id.textViewEnergy);
            activityType = itemView.findViewById(R.id.textViewActivity);
            day = itemView.findViewById(R.id.textViewDay);
            month = itemView.findViewById(R.id.textViewMonth);

        }
    }

    private final LayoutInflater mInflater;
    private List<Workout> mWorkouts = Collections.emptyList();
    private ViewGroup viewGroup;
    private String[] typeArray;


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

      //  Log.i(TAG, "*** current activity: " + current.toString());

        int type = current.getType();
        typeArray = viewGroup.getResources().getStringArray(R.array.array_workout_type);
        String activity = typeArray[type];

       // Log.i(TAG, "*** array value at " + type + ":  " + activity);


        workoutViewHolder.energyLevel.setText(Integer.toString(current.getEnergyExp()));


        //int energy = current.getEnergyExp();
        switch (current.getEnergyExp()){
            case 0:
            case 1:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.light_blue));
                break;
            case 2:
            case 3:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.blue));
                break;
            case 4:
            case 5:
            case 6:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.green));
                break;
            case 7:
            case 8:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.light_orange));
            case 9:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.orange));
                break;
            case 10:
                workoutViewHolder.energyLevel.setTextColor(viewGroup.getResources().getColor(R.color.red));
                break;
        }

        workoutViewHolder.title.setText(current.getTitle());
        workoutViewHolder.summary.setText(current.workoutDetails());
        workoutViewHolder.activityType.setText(activity);

        date d = current.getEmbeddedDate();
        int k = d.getDay();
        workoutViewHolder.day.setText(Integer.toString(k));

        String m;
        switch (current.getEmbeddedDate().getMonth()){
            case 1:
                m = "Jan";
                break;
            case 2:
                m = "Feb";
                break;
            case 3:
                m = "Mar";
                break;
            case 4:
                m = "Apr";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "Jun";
                break;
            case 7:
                m = "Jul";
                break;
            case 8:
                m = "Aug";
                break;
            case 9:
                m = "Sep";
                break;
            case 10:
                m = "Oct";
                break;
            case 11:
                m = "Nov";
                break;
            default:
                m = "Dec";
        }
        workoutViewHolder.month.setText(m);
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
