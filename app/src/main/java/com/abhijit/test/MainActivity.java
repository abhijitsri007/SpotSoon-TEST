package com.abhijit.test;

/**
 * Created by abhijit on 3/5/17.
 */

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.abhijit.test.Fragments.RecyclerViewFragment;
import com.abhijit.test.Fragments.RecyclerViewFragment2;
import com.abhijit.test.Fragments.RecyclerViewFragment3;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    int pageCount = 3;
    private DrawerLayout mDrawerLayout;
    private TabLayout tabLayout;
    Toolbar toolbar;
    private int[] tabIcons = {
            R.drawable.ic_action_video,
            R.drawable.ic_action_image,
            R.drawable.ic_action_milestone
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.parseColor("#fc6902"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ImageView toolbarImage = (ImageView) findViewById(R.id.image);

        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Please Sync your Data", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position==0)
                {
                    return new RecyclerViewFragment();
                }else if(position==1)
                {
                    return new RecyclerViewFragment2();
                }else if(position==2)
                {
                    return new RecyclerViewFragment3();
                }/*else if(position==3)
                {
                    return new RecyclerViewFragment4();
                }else if(position==4)
                {
                    return new RecyclerViewFragment();
                }*/

                return null;
            }

            @Override
            public int getCount() {
                return pageCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {

                switch (position) {
                    case 0:
                        return "VIDEOS";
                    case 1:
                        return "IMAGES";
                    case 2:
                        return "MILESTONE";
                }
                return "";
            }
        });
        setupTabIcons();
        indicator.setViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#FF0000"));
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.deep_orange);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);


                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.cardview_shadow_start_color);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}
