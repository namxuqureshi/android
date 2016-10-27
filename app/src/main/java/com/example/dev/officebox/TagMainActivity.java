package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dev.officebox.Fragment.PlaceholderFragmentAll;
import com.example.dev.officebox.Fragment.PlaceholderFragmentFriend;
import com.example.dev.officebox.Fragment.PlaceholderFragmentYours;


public class TagMainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tag_main);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        /*
      The {@link android.support.v4.view.PagerAdapter} that will provide
      fragments for each of the sections. We use a
      {@link FragmentPagerAdapter} derivative, which will keep every
      loaded fragment in memory. If this becomes too memory intensive, it
      may be best to switch to a
      {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
        final SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(TagMainActivity.this.getSupportFragmentManager());
        final ImageView imgBtn = (ImageView) findViewById(R.id.backBtnImg);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });
        // Set up the ViewPager with the sections adapter.
        /*
      The {@link ViewPager} that will host the section contents.
     */
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Intent msg = new Intent(TagMainActivity.this, NewMessageActivity.class);
                startActivity(msg);
            }
        });
        final TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("Tag Main");

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//                return PlaceholderFragment2.newInstance(position + 1);

            switch (position) {
                case 0:
                    //page 1
                    return PlaceholderFragmentAll.newInstance(1);
                case 1:
                    //page 2
                    return PlaceholderFragmentYours.newInstance(1);
                case 2:
                    //page 2
                    return PlaceholderFragmentFriend.newInstance(1);
                default:
                    //this page does not exists
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            switch (position) {
                case 0:
                    return "All";
                case 1:
                    return "Yours";
                case 2:
                    return "Friends";
            }
            return null;
        }
    }


}