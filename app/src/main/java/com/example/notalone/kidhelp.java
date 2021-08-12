package com.example.notalone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class kidhelp extends AppCompatActivity {
   Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidhelp);
        getSupportActionBar().hide();
        logoutBtn = findViewById(R.id.logout);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            //final ProgressDialog dia = ProgressDialog.show(getApplicationContext(),null,getString(R.string.alert_loading));
            @Override
            public void onClick(View view) {
                //dia.dismiss();
                ParseUser.getCurrentUser().logOut();
                Intent i=new Intent(kidhelp.this,User.class);
                startActivity(i);
                finish();
            }
        });


    }

    public void clickhere(View view) {
        String url = "https://kidshealth.org/en/teens/family-abuse.html";
        Intent i = new Intent(Intent. ACTION_VIEW); i. setData(Uri. parse(url));
        startActivity(i);
    }
}