package com.example.MobilabFitness;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.MobilabFitness.Workout.Workout;
import com.example.MobilabFitness.Workout.WorkoutViewModel;

public class RecordWorkout extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "RecordWorkout";

    private WorkoutViewModel workoutViewModel;

    private EditText editTitle;
    private EditText editTextDate;
    private Button buttonDate;
    private EditText editHours;
    private EditText editMin;
    private EditText editDistance;
    private EditText editCalories;
    private Spinner spinnerType;
    private Spinner spinnerEnergyExp;
    private Button buttonSaveWorkout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_workout);

        editTitle = (EditText) findViewById(R.id.edit_title);
        editTextDate = (EditText) findViewById(R.id.edit_date);
        buttonDate = (Button) findViewById(R.id.btn_date);
        editHours = (EditText) findViewById(R.id.edit_hours);
        editMin = (EditText) findViewById(R.id.edit_min);
        editDistance = (EditText) findViewById(R.id.edit_distance);
        editCalories = (EditText) findViewById(R.id.edit_calories);

        spinnerType = (Spinner) findViewById(R.id.spinner_type);;
        spinnerEnergyExp = (Spinner) findViewById(R.id.spinner_energy_exp);


        workoutViewModel = ViewModelProviders.of(this).get(WorkoutViewModel.class);


        buttonSaveWorkout = (Button) findViewById(R.id.buttonSaveWorkout);
        buttonSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workoutViewModel.insert(new Workout(
                        editTitle.getText().toString(),
                        editTextDate.getText().toString(),
                        getTime(),
                        Integer.parseInt(editDistance.getText().toString()),
                        Integer.parseInt(editCalories.getText().toString()),
                        1,
                        1));
                finish();
            }
        });
    }

    private int getTime() {
        Integer minutes = Integer.parseInt(editHours.getText().toString())*60 + Integer.parseInt(editMin.getText().toString());
        return minutes;
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "" + dayOfMonth + "/" + month + "/" + year;
        Log.i(TAG, "*** date: " + date);
        ((EditText) findViewById(R.id.edit_date)).setText(date);


    }

}
