package com.example.notalone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SigninUser extends AppCompatActivity {
    EditText edName, edEmail, edPassword, edConfirmPassword;
    Button signup;
    int coun=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_user);
        getSupportActionBar().hide();
        ParseInstallation.getCurrentInstallation().saveInBackground();


        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
        signup=findViewById(R.id.signup);
    }


    public void signup(View view) {
            if( TextUtils.isEmpty(edName.getText())){
                edName.setError( "Name is required!" );
            }else if( TextUtils.isEmpty(edEmail.getText())){
                edEmail.setError( "Email is required!" );
            }else if( TextUtils.isEmpty(edPassword.getText())){
                edPassword.setError( "Password is required!" );
            }else if( TextUtils.isEmpty(edConfirmPassword.getText())){
                edConfirmPassword.setError( "Confirm password is required!" );
            }else if(!edPassword.getText().toString().equals(edConfirmPassword.getText().toString())){
                Toast.makeText(SigninUser.this, "Passwords are not the same!", Toast.LENGTH_LONG).show();
            }else{

                final ProgressDialog progress = new ProgressDialog(this);
                progress.setMessage("Loading ...");
                progress.show();
                ParseUser user = new ParseUser();
                user.setUsername(edEmail.getText().toString().trim());
                user.setEmail(edEmail.getText().toString().trim());
                user.setPassword(edPassword.getText().toString());
                user.put("name", edName.getText().toString().trim());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        progress.dismiss();
                        if (e == null) {
                            Toast.makeText(SigninUser.this, "Please verify your mail-id", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SigninUser.this, User.class);
                            startActivity(intent);
                            coun=0;
                            finish();
                        } else {
                            ParseUser.logOut();
                            Toast.makeText(SigninUser.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

    }
}