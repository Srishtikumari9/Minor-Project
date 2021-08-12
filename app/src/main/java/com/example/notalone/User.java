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

import com.parse.ParseUser;

public class User<user> extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button login;


    public void alertDisplayer(String title,String message){
        Toast.makeText(getApplicationContext(),title + " " + message,Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);

        login=findViewById(R.id.loginuser);
        getSupportActionBar().hide();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(ParseUser.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
            finish();
        }
    }

    public void signup(View view) {
            Intent intent = new Intent(User.this, SigninUser.class);
            startActivity(intent);
        }



    public void login(View view) {
        if( TextUtils.isEmpty(edEmail.getText())){
            edEmail.setError( "Email is required!" );
        }else if( TextUtils.isEmpty(edPassword.getText())){
            edPassword.setError( "Password is required!" );
        }else{
            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser.logInInBackground(edEmail.getText().toString(), edPassword.getText().toString() , (parseUser, e) -> {
                progress.dismiss();
                int count=0;
                if (parseUser != null && count==0 ) {
                    //Toast.makeText(User.this, "Welcome back!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(User.this, Dashboard.class);
                    startActivity(intent);

                } else {
                    ParseUser.logOut();
                    alertDisplayer("Login Fail", "Please Verify Your Email first");
                    Toast.makeText(User.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT);
                }


            });
        }

        }

}


