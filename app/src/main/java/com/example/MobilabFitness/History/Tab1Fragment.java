package com.example.MobilabFitness.History;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.MobilabFitness.R;

public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";
    private Button btnTest;

    CalendarView calendarView;
    TextView dateDisplay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        calendarView = (CalendarView) container.findViewById(R.id.calendarView);

        dateDisplay = (TextView) container.findViewById(R.id.textViewShowDate);




//        calendarView = (CalendarView) getView().findViewById(R.id.calendarView);
//        dateDisplay = (TextView) getView().findViewById(R.id.textViewShowDate);




        return inflater.inflate(R.layout.tab1_fragment, container, false);
    }
}
