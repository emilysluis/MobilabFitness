package com.example.MobilabFitness;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment  {


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), (RecordWorkout)getActivity(), year, month, day);
    }
}

