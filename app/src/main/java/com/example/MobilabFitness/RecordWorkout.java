package com.example.MobilabFitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class RecordWorkout extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_workout);

    }


    public void showDatePicker(View view) {
        datePicker.setVisibility(View.VISIBLE);
    }
}
