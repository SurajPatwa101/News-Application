package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,mscince,mhealth,mtechnology,msports,mentertainment;
    PageAdapter  pageAdapter;
    Toolbar mtoolbar;

    String api = "5ecf88e5e00040a08ce628c22be5dd8d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.recylerviewofhome);
        mscince = findViewById(R.id.recylerviewofscience);
        msports = findViewById(R.id.recylerviewofsports);
        mtechnology = findViewById(R.id.recylerviewoftechnology);
        mentertainment = findViewById(R.id.recylerviewofentertainment);
        mhealth = findViewById(R.id.recylerviewofhealth);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        TabLayout tabLayout = findViewById(R.id.tablayout);


        pageAdapter = new PageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0||tab.getPosition() == 1||tab.getPosition() == 2||tab.getPosition() == 3||tab.getPosition() == 4||tab.getPosition() == 5){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}