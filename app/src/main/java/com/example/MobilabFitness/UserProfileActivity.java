package com.example.MobilabFitness;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.MobilabFitness.User.UserViewModel;

public class UserProfileActivity extends AppCompatActivity {

    private static final String TAG = "UserProfileActivity";


    public UserViewModel userViewModel;

//    TextView firstName;
//    TextView lastName;
//    TextView birthday;
//    TextView height;
//    TextView weight;
//    TextView funcLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);





//        firstName = (TextView) findViewById(R.id.textViewFirstName);
//        lastName = (TextView) findViewById(R.id.textViewLastName);
//        birthday = (TextView) findViewById(R.id.text_birthday);
//        height = (TextView) findViewById(R.id.text_height);
//        weight = (TextView) findViewById(R.id.text_weight);
//        funcLevel = (TextView) findViewById(R.id.text_func_level);


    }
}
