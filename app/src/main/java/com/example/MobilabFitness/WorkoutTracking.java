package com.example.MobilabFitness;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class WorkoutTracking extends AppCompatActivity {

    Chronometer chronometer;
    private boolean running;
    private long pauseOffSet;
    Button reset;
    Button stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_tracking);
        running = false;


        chronometer = findViewById(R.id.workoutTimer);
        chronometer.setBase(SystemClock.elapsedRealtime());

        reset = findViewById(R.id.buttonReset);
        reset.setVisibility(View.INVISIBLE);

        stop = findViewById(R.id.buttonStop);
        stop.setVisibility(View.VISIBLE);
    }

    public void startChronometer(View view) {
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            running = true;
            reset.setVisibility(View.INVISIBLE);
            stop.setVisibility(View.VISIBLE);
        }
    }

    public void stopChronometer(View view) {
        if(running) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            reset.setVisibility(View.VISIBLE);
            stop.setVisibility(View.INVISIBLE);
        }
    }

    public void resetChronometer(View view) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffSet = 0;
    }

    public void saveWorkoutTime(View view) {
        startActivity(new Intent(this, RecordWorkout.class));
    }
}
