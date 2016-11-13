package com.example.dev.officebox.adapters;

/**
 * Created by usman on 10/29/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dev.officebox.fragment.PlaceholderFragmentAll;
import com.example.dev.officebox.fragment.PlaceholderFragmentFriend;
import com.example.dev.officebox.fragment.PlaceholderFragmentYours;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(final FragmentManager fm) {
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
                return PlaceholderFragmentAll.newInstance(position);
            case 1:
                //page 2
                return PlaceholderFragmentYours.newInstance(position);
            case 2:
                //page 2
                return PlaceholderFragmentFriend.newInstance(position);
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

