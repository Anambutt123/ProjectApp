package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   // private SectionsPagerAdapter mSectionsPagerAdapter;
   private ViewPager mViewPager;
    public static SectionsPagerAdapter adapter;
    public  static  ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPager();
    }

    private void setupViewPager() {
         adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DonorList());// index = 0
        adapter.addFragment(new DonorInfo());// index = 1
        adapter.addFragment(new AddandSearchDonor());// index = 2
         viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_donor);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_donorinformation);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search);
    }
}