package com.example.MobilabFitness;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.MobilabFitness.User.User;
import com.example.MobilabFitness.User.UserViewModel;

import java.util.List;


public class UserListActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private String TAG = "UserListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> words) {
//                Log.i(TAG, "*** testing getAllWords: " + userViewModel.getAllUsers().getValue().toArray().length);
//
//                Log.i(TAG, "*** array: " + Arrays.toString(userViewModel.getAllUsers().getValue().toArray()));

                // Update the cached copy of the words in the adapter.
                adapter.setUsers(words);
            }
        });




    }

}
