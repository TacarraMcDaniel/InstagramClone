package com.codepath.tmcda.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    private EditText etsignUsername;
    private EditText etSignPassword;
    private EditText etEmail;
    private Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser()!=null){
            goMainActivity();
        }

        etsignUsername = findViewById(R.id.etsignUsername);
        etSignPassword = findViewById(R.id.etSignPassword);
        etEmail = findViewById(R.id.etEmail);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick login button");
                String username = etsignUsername.getText().toString();
                String password = etSignPassword.getText().toString();
                String email = etEmail.getText().toString();
                signupUser(username,password,email);

            }
        });


    }
    private  void signupUser(String username, String password, String email){
        Log.i(TAG, "Attempting to sign up"+username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Log.e(TAG, "Issues with login,",e);
                    Toast.makeText(SignUp.this
                            , "Issues with login", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(SignUp.this, "Success", Toast.LENGTH_SHORT).show();


            }
        });
    }


    private void goMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }





}