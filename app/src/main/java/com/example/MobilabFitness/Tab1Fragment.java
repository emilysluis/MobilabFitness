package com.example.MobilabFitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import org.jetbrains.annotations.NotNull;

public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";

    CalendarView calendarView;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        calendarView = container.findViewById(R.id.calendarView);

        return inflater.inflate(R.layout.tab1_fragment, container, false);
    }
}
