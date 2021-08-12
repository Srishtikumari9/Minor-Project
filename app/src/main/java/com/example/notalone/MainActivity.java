package com.example.notalone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button user,couns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.user);
        couns=findViewById(R.id.counsellor);
        getSupportActionBar().hide();

    }


    public void userclicked(View view) {

        Intent i=new Intent(MainActivity.this,User.class);
        startActivity(i);
    }

    public void counclicked(View view) {
        Intent intent=new Intent(MainActivity.this,Counsellor.class);
        startActivity(intent);

    }


}
