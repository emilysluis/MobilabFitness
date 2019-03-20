package com.example.MobilabFitness;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment  {


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

//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        // Do something with the date chosen by the user
//        Toast.makeText(getActivity(), "selected date is " + view.getYear() +
//                            " / " + (view.getMonth()+1) +
//                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();
//
//    }



//    private DatePickerDialog.OnDateSetListener dateSetListener =
//            new DatePickerDialog.OnDateSetListener() {
//                public void onDateSet(DatePicker view, int year, int month, int day) {
//                    Toast.makeText(getActivity(), "selected date is " + view.getYear() +
//                            " / " + (view.getMonth()+1) +
//                            " / " + view.getDayOfMonth(), Toast.LENGTH_SHORT).show();
//                }
//            };
}

