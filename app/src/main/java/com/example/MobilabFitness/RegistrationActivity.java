package com.example.MobilabFitness;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.MobilabFitness.User.User;
import com.example.MobilabFitness.User.UserViewModel;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RegistrationActivity";

    private UserViewModel userViewModel;


    private EditText editFirstName;
    private EditText editLastName;
    private EditText editBirthday;
    private Spinner spinnerGender;
    private EditText editHeight;
    private EditText editWeight;
    private Spinner spinnerFuncLevel;

    private int gender;
    private int funcLevel;

    Button btnDatePicker;
    private int mYear, mMonth, mDay;

    //public int userCount;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);




        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edit_last_name);
        editBirthday = findViewById(R.id.edit_birthday);
        spinnerGender = findViewById(R.id.spinner_gender);
        editHeight = findViewById(R.id.edit_height);
        editWeight = findViewById(R.id.edit_weight);

        spinnerFuncLevel = findViewById(R.id.spinner_functional_level);

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnDatePicker.setOnClickListener(this);


        setupSpinner();
        setupFuncLevelSpinner();



        final Button button = findViewById(R.id.register_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                //TODO: add other attributes once set up
                userViewModel.insert(new User(
                        editFirstName.getText().toString(),
                        editLastName.getText().toString(),
                        editBirthday.getText().toString(),
                        gender,
                        Integer.parseInt(editHeight.getText().toString()),
                        Integer.parseInt(editWeight.getText().toString()),
                        funcLevel));


                Log.i(TAG, "*** testing getAllWords: " + userViewModel.getAllUsers().getValue().toArray().length);



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



    /**
     * Setup the dropdown spinner that allows the user to select the gender of the user.
     */
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

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        spinnerGender.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
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
            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = 0;
            }
        });


    }

}
