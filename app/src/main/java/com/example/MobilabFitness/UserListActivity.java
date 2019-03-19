package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.appDatabase;

import java.util.List;


public class UserListActivity extends AppCompatActivity {

    //private UserViewModel userViewModel;
    private String TAG = "UserListActivity";


    private static final String DATABASE_NAME = "app_db";
    private appDatabase appDatabase;

    private List<User> listOfUsers;
    private TextView showNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        showNumber = (TextView) findViewById(R.id.textViewUserNum);

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

                showNumber.setText(new StringBuilder().append("Number of users in the database: ").append(appDatabase.userDao().getUserCount()).toString());


            }
        }) .start();






    }

}
