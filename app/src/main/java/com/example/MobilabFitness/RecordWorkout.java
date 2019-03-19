package com.example.MobilabFitness;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.appDatabase;

public class RecordWorkout extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "RecordWorkout";

    private EditText editTitle;
    private EditText editTextDate;
    private EditText editHours;
    private EditText editMin;
    private EditText editDistance;
    private EditText editCalories;
    private Spinner spinnerType;

    private Button buttonSaveWorkout;

    private Spinner spinnerNew;
    private Spinner spinnerEnergyExp;


    private appDatabase appDatabase;
    private static final String DATABASE_NAME = "app_db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_workout);

        editTitle = findViewById(R.id.edit_title);
        editTextDate = findViewById(R.id.edit_date);
        editHours = findViewById(R.id.edit_hours);
        editMin = findViewById(R.id.edit_min);
        editDistance = findViewById(R.id.edit_distance);
        editCalories = findViewById(R.id.edit_calories);

        spinnerType = findViewById(R.id.spinner_type);
        spinnerEnergyExp = findViewById(R.id.spinner_energy_exp);


        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();


        buttonSaveWorkout = (Button) findViewById(R.id.buttonSaveWorkout);
        buttonSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = "*** value of editTextDate.getText().toString().isEmpty() : [" + (  editTextDate.getText().toString().isEmpty()   ) + "]";
                Log.i(TAG, string);


                if(editTitle.getText().toString().isEmpty()){
                    Snackbar.make(v, "TITLE required to save workout", Snackbar.LENGTH_LONG).show();
                    //Toast.makeText(RecordWorkout.this, "Title required", Toast.LENGTH_LONG).show();
                }
                else if(editTextDate.getText().toString().isEmpty()){
                    Snackbar.make(v, "DATE Required to save workout", Snackbar.LENGTH_LONG).show();
                }
                else {

                    insertWorkout();

                    finish();
                }
            }
        });


    }//end onCreate

    private void insertWorkout(){
        final String title = editTitle.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final int time = getTime();



        new Thread(new Runnable() {
            @Override
            public void run() {
                int dist = -1;
                if(!editDistance.getText().toString().isEmpty())
                    dist = Integer.parseInt(editDistance.getText().toString());

                int cal = -1;
                if(!editCalories.getText().toString().isEmpty()){
                    cal = Integer.parseInt(editCalories.getText().toString());
                }

                Workout workout = new Workout(title, date, time, dist, cal, 0,0);
                appDatabase.workoutDao().insert(workout);

            }
        }) .start();

    }



    private int getTime() {
        if(!editMin.getText().toString().isEmpty() && !editHours.getText().toString().isEmpty()){
            int mins = Integer.parseInt(editMin.getText().toString());
            int hrs = Integer.parseInt(editHours.getText().toString());
            return hrs * 60 + mins;
        }
        else if(!editHours.getText().toString().isEmpty()){
            int hrs = Integer.parseInt(editHours.getText().toString());
            return hrs * 60;
        }
        else if(!editMin.getText().toString().isEmpty()) {
            int mins = Integer.parseInt(editMin.getText().toString());
            return mins;
        }
        else{
            return -1;
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        //Date date = new Date(view.getYear(), view.getMonth(), view.getDayOfMonth());


        //Log.i(TAG, "*** year: " + date.getYear());

        //SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy");

        //String stringDate = formatter.format(date);

        //Log.i(TAG, "*** formatted date: " + stringDate);

        String day = "" + dayOfMonth + "/" + month + "/" + year;
        Log.i(TAG, "*** date: " + day);
        ((EditText) findViewById(R.id.edit_date)).setText(day);


    }


}
