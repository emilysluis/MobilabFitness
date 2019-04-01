package com.example.MobilabFitness;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.appDatabase;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RegistrationActivity";



    private EditText editFirstName;
    private EditText editLastName;
    private EditText editBirthday;
    private Spinner spinnerGender;
    private EditText editHeight;
    private EditText editWeight;
    private Spinner spinnerFuncLevel;

    private int gender;
    private int funcLevel;

    private Button btnDatePicker;
    private int mYear, mMonth, mDay;

    private appDatabase appDatabase;
    private static final String DATABASE_NAME = "app_db";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();


        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edit_last_name);
        editBirthday = findViewById(R.id.edit_birthday);
        spinnerGender = findViewById(R.id.spinner_gender);
        editHeight = findViewById(R.id.edit_height);
        editWeight = findViewById(R.id.edit_weight);

        spinnerFuncLevel = findViewById(R.id.spinner_type);

        btnDatePicker= findViewById(R.id.btn_date);
        btnDatePicker.setOnClickListener(this);


        setupSpinner();
        setupFuncLevelSpinner();



        final Button button = findViewById(R.id.register_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                final User user = new User(
                        editFirstName.getText().toString(),
                        editLastName.getText().toString(),
                        editBirthday.getText().toString(),
                        gender,
                        Integer.parseInt(editHeight.getText().toString()),
                        Integer.parseInt(editWeight.getText().toString()),
                        funcLevel);


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        appDatabase.userDao().insertOnlySingleMovie(user);
                    }
                }) .start();

                Toast.makeText(getApplicationContext(), "insert(): " + user.toString(), Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }



    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            editBirthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" +  year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    private void setupFuncLevelSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_functional_level_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerFuncLevel.setAdapter(genderSpinnerAdapter);

        spinnerFuncLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if(selection.equals(getString(R.string.quad))){
                        funcLevel = 1;
                    }
                    else if(selection.equals(getString(R.string.high))){
                        funcLevel = 2;
                    }
                    else if(selection.equals(getString(R.string.low))){
                        funcLevel = 3;
                    }
                    else{
                        funcLevel = 0;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               funcLevel = 0;
            }
        });
    }

    private void setupSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerGender.setAdapter(genderSpinnerAdapter);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if(selection.equals(getString(R.string.gender_male))){
                        gender = 1;
                    }
                    else if(selection.equals(getString(R.string.gender_female))){
                        gender = 2;
                    }
                    else{
                        gender = 0;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = 0;
            }
        });


    }
}
