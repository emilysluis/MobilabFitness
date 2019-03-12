package com.example.MobilabFitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.MobilabFitness.History.History;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton =
                (FloatingActionButton) findViewById(R.id.floatingActionButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu_tracking_activities);
                popup.show();
            }
        });

    }//end onCreate

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.allDayTracking:
                startActivity(new Intent(this, TrackAllDay.class));
                return true;
            case R.id.workoutTracking:
                startActivity(new Intent(this, WorkoutTracking.class));
                return true;
            case R.id.manualEntry:
                startActivity(new Intent(this, RecordWorkout.class));
                return true;

            default:
                return false;
        }
    }

//    public void loginRegister(View view) {
//        startActivity(new Intent(this, LoginActivity.class));
//    }

    public void register(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void history(View view) {
        startActivity(new Intent(this, History.class));
    }

    public void profile(View view) { startActivity(new Intent(this, UserProfileActivity.class));
    }

    public void userList(View view) {
        startActivity(new Intent(this, UserListActivity.class));
    }
}
