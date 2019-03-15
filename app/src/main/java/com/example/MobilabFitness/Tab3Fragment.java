package com.example.MobilabFitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab3_fragment, viewGroup, false);
    }
}
