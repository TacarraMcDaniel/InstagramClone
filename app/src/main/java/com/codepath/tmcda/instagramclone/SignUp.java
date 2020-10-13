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

    String stUname, stPwd, stEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        etsignUsername = findViewById(R.id.etsignUsername);
        etSignPassword = findViewById(R.id.etSignPassword);
        etEmail = findViewById(R.id.etEmail);
        Register = findViewById(R.id.Register);



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                stUname = etsignUsername.getText().toString();
                stPwd = etSignPassword.getText().toString();
                stEmail = etEmail.getText().toString();
                user.setUsername(stUname);
                user.setPassword(stPwd);
                user.setEmail(stEmail);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUp.this,MainActivity.class);
                          i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                          i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                          startActivity(i);
                       } else {
                            Toast.makeText(SignUp.this, "Sign Up unsuccessful", Toast.LENGTH_SHORT).show();


                        }

                    }
                });
            }
        });





}
    }