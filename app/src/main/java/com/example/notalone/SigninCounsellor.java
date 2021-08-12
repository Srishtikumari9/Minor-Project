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
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SigninCounsellor extends AppCompatActivity {
    Button ccsignup;
    EditText ccName, ccEmail, ccPassword, ccConfirmPassword;
    int coun=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_counsellor);
        ccsignup=findViewById(R.id.ccsignup);
        ccName = findViewById(R.id.ccName);
        ccEmail = findViewById(R.id.ccEmail);
        ccPassword = findViewById(R.id.ccPassword);
        ccConfirmPassword = findViewById(R.id.ccConfirmPassword);
        ccsignup=findViewById(R.id.ccsignup);
        getSupportActionBar().hide();
    }

    public void ccsignup(View view) {
        if( TextUtils.isEmpty(ccName.getText())){
            ccName.setError( "Name is required!" );
        }else if( TextUtils.isEmpty(ccEmail.getText())){
            ccEmail.setError( "Email is required!" );
        }else if( TextUtils.isEmpty(ccPassword .getText())){
            ccPassword .setError( "Password is required!" );
        }else if( TextUtils.isEmpty(ccConfirmPassword.getText())){
            ccConfirmPassword.setError( "Confirm password is required!" );
        }else if(!ccPassword.getText().toString().equals(ccConfirmPassword.getText().toString())){
            Toast.makeText(SigninCounsellor.this, "Passwords are not the same!", Toast.LENGTH_LONG).show();
        }else{

            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser user = new ParseUser();
            user.setUsername(ccEmail.getText().toString().trim());
            user.setEmail(ccEmail.getText().toString().trim());
            user.setPassword(ccPassword.getText().toString());
            user.put("name", ccName.getText().toString().trim());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    progress.dismiss();
                    if (e == null) {
                        Toast.makeText(SigninCounsellor.this, "Please verify your mail-id to login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SigninCounsellor.this, Counsellor.class);
                        startActivity(intent);
                        coun=1;
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(SigninCounsellor.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}