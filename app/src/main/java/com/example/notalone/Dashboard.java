package com.example.notalone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    Button pub, school, work, kid;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        pub = findViewById(R.id.public1);
        school = findViewById(R.id.school);
        work = findViewById(R.id.work);
        kid = findViewById(R.id.kid);


        getSupportActionBar().hide();


    }

    public void schoolclicked(View view) {
        Intent i=new Intent(Dashboard.this,PublicActivity.class);
        startActivity(i);
    }

    public void kidclicked(View view) {
        Intent intent=new Intent(Dashboard.this,kidhelp.class);
        startActivity(intent);
    }

    public void workplaceclicked(View view) {
        Intent i=new Intent(Dashboard.this,PublicActivity.class);
        startActivity(i);
    }

    public void publicclicked(View view) {
        Intent i=new Intent(Dashboard.this,PublicActivity.class);
        startActivity(i);
    }


    public void google(View view) {
        Intent ii=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(ii);
    }

    public void facebook(View view) {
        Intent iii=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(iii);

    }

    public void instagram(View view) {
        Intent iiii=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
        startActivity(iiii);

    }
}
   