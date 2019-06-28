package com.example.news;
import android.support.design.widget.TabLayout;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.example.news.Fragments.FragmentChannels;
import com.example.news.Fragments.FragmentHeadlines;
import com.example.news.Model.Channels;
import com.example.news.Model.Headlines;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager =(ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddingFragment(new FragmentHeadlines(), "اخر الاخبار");
        adapter.AddingFragment(new FragmentChannels(), "اقسام متنوعه");
//        adapter.AddingFragment(new VideoFragment(),"الفيديوهات");
        viewPager.setAdapter(adapter);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        TextView textView = findViewById(R.id.text_headlines);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Headlines.class);
                startActivity(intent);
            }
        });
        TextView textView1 = findViewById(R.id.text_channels);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Channels.class);
                startActivity(intent1);
            }
        });
    }


    }



