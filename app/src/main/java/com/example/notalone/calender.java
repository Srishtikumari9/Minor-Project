package com.example.notalone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class calender extends AppCompatActivity {
    EditText title,description;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        title=findViewById(R.id.etTitle);
        description=findViewById(R.id.etDescription);
        addEvent=findViewById(R.id.btnAdd);
        getSupportActionBar().hide();

        addEvent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                if(!title.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){
                    Intent in=new Intent(Intent.ACTION_INSERT);
                    in.setData(CalendarContract.Events.CONTENT_URI);

                    in.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                    in.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                    in.putExtra(CalendarContract.Events.ALL_DAY,"true");
                    in.putExtra(Intent.EXTRA_EMAIL,"");

                    if(in.resolveActivity(getPackageManager())!= null)
                    {
                        startActivity(in);

                    }
                    else
                    {
                        Toast.makeText(calender.this,"to app that supports this action",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(calender.this,"please fill all the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}