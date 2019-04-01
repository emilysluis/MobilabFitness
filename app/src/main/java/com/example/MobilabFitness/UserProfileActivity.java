package com.example.MobilabFitness;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.MobilabFitness.Database.User;
import com.example.MobilabFitness.Database.appDatabase;

import java.util.List;

public class UserProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "UserProfileActivity";

    private appDatabase appDatabase;
    private static final String DATABASE_NAME = "app_db";

    TextView firstName;
    TextView lastName;
    TextView birthday;
    TextView height;
    TextView weight;
    TextView funcLevel;

    List<User> listOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        appDatabase = Room.databaseBuilder(getApplicationContext(), appDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        updateUserList updateUserList = new updateUserList();
        updateUserList.execute();


        firstName = findViewById(R.id.textViewFirstName);
        lastName = findViewById(R.id.textViewLastName);
        birthday = findViewById(R.id.text_birthday);
        height = findViewById(R.id.text_height);
        weight = findViewById(R.id.text_weight);
        funcLevel = findViewById(R.id.text_func_level);

        if(listOfUsers != null && !listOfUsers.isEmpty()){
            User curr = listOfUsers.get(1);
            firstName.setText(curr.getFirstName());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        User current = listOfUsers.get(position);
        firstName.setText(current.getFirstName());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        User temp = new User("firstName", "lastName", "23/05/1998", 2, 180, 2, 1);
        firstName.setText(temp.getFirstName());
    }


    public class updateUserList extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            listOfUsers = appDatabase.userDao().getAllUsers();
            Spinner spinnerUser = findViewById(R.id.spinner_user);

            if (listOfUsers != null && !listOfUsers.isEmpty()) {
                Log.i(TAG, "*** " + listOfUsers);
                ArrayAdapter<User> adapter = new ArrayAdapter<>(UserProfileActivity.this, android.R.layout.simple_list_item_1, listOfUsers);

                spinnerUser.setAdapter(adapter);
            }
            else {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Please register a USER before continuing", Snackbar.LENGTH_LONG)
                        .setAction("Register", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(UserProfileActivity.this, RegistrationActivity.class));
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();
            }
            return null;
        }
    }
}
