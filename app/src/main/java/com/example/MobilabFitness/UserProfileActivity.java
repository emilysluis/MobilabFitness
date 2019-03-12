package com.example.MobilabFitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.MobilabFitness.User.UserViewModel;

public class UserProfileActivity extends AppCompatActivity {

    private static final String TAG = "UserProfileActivity";


    public UserViewModel userViewModel;
    int userCount;
    int currUser;

    TextView firstName;
    TextView lastName;
    TextView birthday;
    TextView height;
    TextView weight;
    TextView funcLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firstName = (TextView) findViewById(R.id.textViewFirstName);
        lastName = (TextView) findViewById(R.id.textViewLastName);
        birthday = (TextView) findViewById(R.id.text_birthday);
        height = (TextView) findViewById(R.id.text_height);
        weight = (TextView) findViewById(R.id.text_weight);
        funcLevel = (TextView) findViewById(R.id.text_func_level);


        //userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


    }


}
