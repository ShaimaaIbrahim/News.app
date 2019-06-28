package com.example.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class abraj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogery);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new AbrajFragment()).commit();

    }
}
