package com.example.MobilabFitness;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.MobilabFitness.User.UserViewModel;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditUserView;
    private UserViewModel userViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mEditUserView = findViewById(R.id.edit_first_name);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        final Button button = findViewById(R.id.register_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //TODO: add userViewModel.insert() method here.... need to declare userConstructor


//                Intent replyIntent = new Intent();
//                if (TextUtils.isEmpty(mEditUserView.getText())) {
//                    setResult(RESULT_CANCELED, replyIntent);
//                } else {
//                    String word = mEditUserView.getText().toString();
//                    Log.i(TAG, "******First name inputted:  " + word+ "*******");
//                    replyIntent.putExtra(EXTRA_REPLY, word);
//                    setResult(RESULT_OK, replyIntent);
//                }
                finish();
            }
        });
    }

}
