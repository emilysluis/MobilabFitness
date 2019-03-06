package com.example.MobilabFitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class Tab2Fragment extends Fragment {

    private static final String TAG = "Tab2Fragment";
    private Button btnTest;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
//        btnTest = (Button) view.findViewById(R.id.buttonTab2);
//
//        btnTest.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 2", Toast.LENGTH_SHORT).show();
//            }
//        });

        ListView listView = (ListView) view.findViewById(R.id.workout_list);

        return view;
    }
}
