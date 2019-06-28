package com.example.news.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.news.R;
import com.example.news.Fragments.FragmentChannels;

public class Channels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogery);
        /*
        to tie Activity with Fragment
        and replace Activity with Fragment
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentChannels()).commit();
    }
}
