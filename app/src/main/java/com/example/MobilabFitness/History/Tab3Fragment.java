package com.example.MobilabFitness.History;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MobilabFitness.R;

public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab3_fragment, viewGroup, false);
    }
}
