package com.example.notalone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class DashboardCounsellor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_counsellor);
        getSupportActionBar().hide();
    }

    public void schedule(View view) {
        Intent i=new Intent(DashboardCounsellor.this,calender.class);
        startActivity(i);
    }

    public void userlist(View view) {
        Intent i=new Intent(DashboardCounsellor.this,UserList1.class);
        startActivity(i);

    }

    public void logout1(View view) {
        ParseUser.logOut();
        message.message(getApplicationContext(), "Logged out");
        finish();
    }
}