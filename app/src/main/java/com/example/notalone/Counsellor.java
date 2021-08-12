package com.example.notalone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class Counsellor extends AppCompatActivity {

    EditText ccEmail, ccPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor);
        getSupportActionBar().hide();
        ccEmail = findViewById(R.id.ccEmail);
        ccPassword = findViewById(R.id.ccPassword);
        getSupportActionBar().hide();


    }
    @Override
    protected void onStart() {
        super.onStart();
        if(ParseUser.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),DashboardCounsellor.class));
            finish();
        }
    }

        public void startcoun(View view) {
            Intent intent = new Intent(Counsellor.this, SigninCounsellor.class);
            startActivity(intent);
        }

    public void logincoun(View view) {
        if( TextUtils.isEmpty(ccEmail.getText())){
            ccEmail.setError( "Email is required!" );
        }else if( TextUtils.isEmpty(ccPassword.getText())){
            ccPassword.setError( "Password is required!" );
        }else{
            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser.logInInBackground(ccEmail.getText().toString(), ccPassword.getText().toString() , (parseUser, e) -> {
                progress.dismiss();
                if (parseUser != null) {
                    //Toast.makeText(User.this, "Welcome back!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Counsellor.this, DashboardCounsellor.class);
                    startActivity(intent);
                } else {
                    ParseUser.logOut();
                    Toast.makeText(Counsellor.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}