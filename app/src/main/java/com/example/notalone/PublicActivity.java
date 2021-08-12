package com.example.notalone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PublicActivity extends AppCompatActivity {
    RadioGroup rglanguages;
    Button click;
    //int checked;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);


        rglanguages = findViewById(R.id.rglanguages);
        click = findViewById(R.id.btn_click);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = rglanguages.getCheckedRadioButtonId();
                if (checkedId == -1) {
                    //no radio button
                    com.example.notalone.message.message(getApplicationContext(),"Please select option");
                }
                else {
                    findRadioButton(checkedId);
                }
            }
        });
    }

    private void findRadioButton(int checkedId) {
        switch (checkedId){
            case R.id.radioButton:
                com.example.notalone.message.message(getApplicationContext(), "assigned");
                Intent i=new Intent(PublicActivity.this, com.example.notalone.UserList.class);
                startActivity(i);
                break;

            case R.id.radioButton2:
                com.example.notalone.message.message(getApplicationContext(), " assigned");
                Intent ii=new Intent(PublicActivity.this, com.example.notalone.UserList.class);
                startActivity(ii);
                break;
            case R.id.radioButton3:
                com.example.notalone.message.message(getApplicationContext(), "assigned ");
                Intent iii=new Intent(PublicActivity.this, com.example.notalone.UserList.class);
                startActivity(iii);
                break;
        }
    }
}