package com.example.MobilabFitness;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.appDatabase;

import java.util.List;

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

    private Spinner spinnerUser;

    private Spinner spinnerEnergyExp;


    private appDatabase appDatabase;
    private static final String DATABASE_NAME = "app_db";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_workout);

        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        updateUserList updateUserList = new updateUserList();
        updateUserList.execute();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                listOfUsers = appDatabase.userDao().getAllUsers();
//            }
//        }).start();

//        setUpUserSpinner();

//        if (!setUpUserSpinner()) {
//            View parentLayout = findViewById(android.R.id.content);
//             Snackbar.make(parentLayout, "Please register a USER before continuing", Snackbar.LENGTH_LONG)
//                    .setAction("Register", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            startActivity(new Intent(RecordWorkout.this, RegistrationActivity.class));
//                        }
//                    }).setActionTextColor(getResources().getColor(R.color.colorAccent))
//                    .show();
//        }


        editTitle = findViewById(R.id.edit_title);
        editTextDate = findViewById(R.id.edit_date);
        editHours = findViewById(R.id.edit_hours);
        editMin = findViewById(R.id.edit_min);
        editDistance = findViewById(R.id.edit_distance);
        editCalories = findViewById(R.id.edit_calories);

        spinnerType = findViewById(R.id.spinner_type);

        spinnerEnergyExp = findViewById(R.id.spinner_energy_exp);


        buttonSaveWorkout = findViewById(R.id.buttonSaveWorkout);
        buttonSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = "*** value of editTextDate.getText().toString().isEmpty() : [" + (editTextDate.getText().toString().isEmpty()) + "]";
                Log.i(TAG, string);

                if (editTitle.getText().toString().isEmpty()) {
                    Snackbar.make(v, "TITLE required to save workout", Snackbar.LENGTH_LONG).show();
                } else if (editTextDate.getText().toString().isEmpty()) {
                    Snackbar.make(v, "DATE Required to save workout", Snackbar.LENGTH_LONG).show();
                } else {
                    insertWorkout();

                    finish();
                }
            }
        });

    }//end onCreate

    private int getSpinnerTypeValue() {
        int type = spinnerType.getSelectedItemPosition();
        //Log.i(TAG, "*** Value of type spinner: "+ type);
        return type;
    }
    private int getSpinnerEnergyExpValue() {
        int value = spinnerEnergyExp.getSelectedItemPosition();
        //Log.i(TAG, "*** Value of energy exp spinner: "+ value);
        return value;
    }

    private User getSpinnerUser() {
        User  selected = (User) spinnerUser.getSelectedItem();
        //Log.i(TAG, "*** user spinner: "+ selected);
        return selected;
    }


    public class updateUserList extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            List<User> listOfUsers = appDatabase.userDao().getAllUsers();
            Spinner spinnerUser = findViewById(R.id.spinnerUsers);

            if (listOfUsers != null && !listOfUsers.isEmpty()) {
                Log.i(TAG, "*** " + listOfUsers);
                ArrayAdapter<User> adapter = new ArrayAdapter<>(RecordWorkout.this, android.R.layout.simple_list_item_1, listOfUsers);

                
                spinnerUser.setAdapter(adapter);
            }
            else {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Please register a USER before continuing", Snackbar.LENGTH_LONG)
                        .setAction("Register", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(RecordWorkout.this, RegistrationActivity.class));
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();
            }
            return null;
        }
    }



//    private boolean setUpUserSpinner() {
//        spinnerUser = findViewById(R.id.spinnerUsers);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                listOfUsers = appDatabase.userDao().getAllUsers();
//            }
//        }).start();
//
//        if (listOfUsers != null) {
//            Log.i(TAG, "*** listOfUsers!=null");
//            ArrayAdapter<User> adapter = new ArrayAdapter<>(RecordWorkout.this, android.R.layout.simple_list_item_1, listOfUsers);
//
//            spinnerUser.setAdapter(adapter);
//            return true;
//        }
//        return false;
//    }

    private void insertWorkout() {
        final String title = editTitle.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final int time = getTime();

        final int type = spinnerType.getSelectedItemPosition();
        final int energyValue = spinnerEnergyExp.getSelectedItemPosition();

        //final int typeValue = getSpinnerTypeValue();
        //final int energyValue = getSpinnerEnergyExpValue();
        //User selected = getSpinnerUser();

        //Log.i(TAG, "*** type: " + typeValue + "   energy: " + energyValue + "  selected user: " +selected.toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                int dist = -1;
                if (!editDistance.getText().toString().isEmpty())
                    dist = Integer.parseInt(editDistance.getText().toString());

                int cal = -1;
                if (!editCalories.getText().toString().isEmpty()) {
                    cal = Integer.parseInt(editCalories.getText().toString());
                }

                Workout workout = new Workout(title, date, time, dist, cal, type, energyValue);
                appDatabase.workoutDao().insert(workout);

            }
        }).start();

    }


    private int getTime() {
        if (!editMin.getText().toString().isEmpty() && !editHours.getText().toString().isEmpty()) {
            int mins = Integer.parseInt(editMin.getText().toString());
            int hrs = Integer.parseInt(editHours.getText().toString());
            return hrs * 60 + mins;
        } else if (!editHours.getText().toString().isEmpty()) {
            int hrs = Integer.parseInt(editHours.getText().toString());
            return hrs * 60;
        } else if (!editMin.getText().toString().isEmpty()) {
            int mins = Integer.parseInt(editMin.getText().toString());
            return mins;
        } else {
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
