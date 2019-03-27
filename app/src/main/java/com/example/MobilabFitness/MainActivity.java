package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.Workout;
import com.example.MobilabFitness.Database.appDatabase;
import com.example.MobilabFitness.Database.date;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private String TAG = "MainActivity";

    private static final String DATABASE_NAME = "app_db";
    private appDatabase appDatabase;


    private TextView currUser;
    private int selectedUser;
//    private UserViewModel userViewModel;
//    private WorkoutViewModel workoutViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "*** Starting from main on create");

//        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
//        workoutViewModel = ViewModelProviders.of(this).get(WorkoutViewModel.class);
//
//        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//                Log.i(TAG, "*** testing getAllUser: "
//                        + userViewModel.getAllUsers().getValue().toArray().length);
//
//                Log.i(TAG, "*** User array: "
//                        + Arrays.toString(userViewModel.getAllUsers().getValue().toArray()));
//
//            }
//        });
//
//        workoutViewModel.getAllWorkouts().observe(this, new Observer<List<Workout>>() {
//            @Override
//            public void onChanged(@Nullable List<Workout> workouts) {
//                Log.i(TAG, "*** testing getAllWorkouts: "
//                + workoutViewModel.getAllWorkouts().getValue().toArray().length);
//
//                Log.i(TAG, "*** Workout array: " +
//                         Arrays.toString(workoutViewModel.getAllWorkouts().getValue().toArray()));
//            }
//        });

        FloatingActionButton floatingActionButton =
                findViewById(R.id.floatingActionButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu_tracking_activities);
                popup.show();
            }
        });

        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();


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
        final Workout workout1 = new Workout("Morning practice", "01/01/2019", 75, 2, 500, 8, 3, date1);

        final date date2 = new date(19, 03, 2018);
        final Workout workout2 = new Workout("Evening ride", "19/03/2018", 120, 10, 800, 5, 5, date2);

        final date date3 = new date(28, 7, 2017);
        final Workout workout3 = new Workout("Row", "28/07/2017", 45, 2, 1000, 10, 9, date3);


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
