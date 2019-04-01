package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.appDatabase;
import com.example.MobilabFitness.Database.date;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    private static final String DATABASE_NAME = "app_db";
    private appDatabase appDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();

        Log.i(TAG, "*** Starting from main on create");


//        FloatingActionButton floatingActionButton =
//                findViewById(R.id.floatingActionButton);
//
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupMenu popup = new PopupMenu(MainActivity.this, v);
//                popup.setOnMenuItemClickListener(MainActivity.this);
//                popup.inflate(R.menu.menu_tracking_activities);
//                popup.show();
//            }
//        });


    }//end onCreate

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
//        switch (item.getItemId()) {
//            case R.id.allDayTracking:
//                startActivity(new Intent(this, TrackAllDay.class));
//                return true;
//            case R.id.workoutTracking:
//                startActivity(new Intent(this, WorkoutTracking.class));
//                return true;
//            case R.id.manualEntry:
//                startActivity(new Intent(this, RecordWorkout.class));
//                return true;
//            default:
//                return false;
//        }
//    }




    public void register(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void history(View view) {
        startActivity(new Intent(this, History.class));
    }

    public void profile(View view) {
        startActivity(new Intent(this, UserProfileActivity.class));
    }

    public void userList(View view) {
        startActivity(new Intent(this, UserListActivity.class));
    }

    public void logWorkout(View view) {
        startActivity(new Intent(this, RecordWorkout.class));
    }


    public void Populate(View view) {
        PopulateDatabase();
        Toast.makeText(this, "Database filled", Toast.LENGTH_LONG).show();
    }


    public void PopulateDatabase(){

//        appDatabase = Room.databaseBuilder(getApplicationContext(), com.example.MobilabFitness.Database.appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
//                .build();

        final User user1 = new User("Dummy", "Data", "01/01/2000", 1, 160, 60, 1);
        final User user2 = new User("Mickey", "Mouse", "18/11/1928", 1, 96, 10, 2);
        final User user3 = new User("Chester", "TheCat", "15/05/2008", 1, 50, 5, 3);


        final date date1 = new date(1, 1, 2019);
        final Workout workout1 = new Workout("Morning practice", 1, 75, 2, 500, 8, 3, date1);

        final date date2 = new date(19, 03, 2019);
        final Workout workout2 = new Workout("Evening ride", 3, 120, 10, 800, 5, 5, date2);

        final date date3 = new date(28, 2, 2019);
        final Workout workout3 = new Workout("Row", 2, 45, 2, 1000, 10, 9, date3);


        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao().insertOnlySingleMovie(user1);
                appDatabase.userDao().insertOnlySingleMovie(user2);
                appDatabase.userDao().insertOnlySingleMovie(user3);

                appDatabase.workoutDao().insert(workout1);
                appDatabase.workoutDao().insert(workout2);
                appDatabase.workoutDao().insert(workout3);

            }
        }) .start();
    }
}
