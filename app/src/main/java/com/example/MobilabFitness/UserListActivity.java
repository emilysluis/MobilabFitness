package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.MobilabFitness.User.User;
import com.example.MobilabFitness.User.appDatabase;

import java.util.List;


public class UserListActivity extends AppCompatActivity {

    //private UserViewModel userViewModel;
    private String TAG = "UserListActivity";


    private static final String DATABASE_NAME = "app_db";
    private appDatabase appDatabase;

    private List<User> listOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
     //   userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                listOfUsers = appDatabase.userDao().getAllUsers();

                adapter.setUsers(listOfUsers);
            }
        }) .start();








        //        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable final List<User> words) {
////                Log.i(TAG, "*** testing getAllWords: " + userViewModel.getAllUsers().getValue().toArray().length);
////
////                Log.i(TAG, "*** array: " + Arrays.toString(userViewModel.getAllUsers().getValue().toArray()));
//
//                // Update the cached copy of the words in the adapter.
//                adapter.setUsers(words);
//            }
//        });




    }

}
