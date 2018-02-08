package com.example.sebastian.reservalabapp.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sebastian.reservalabapp.fragments.GetHoursFragment;
import com.example.sebastian.reservalabapp.fragments.HomeFragment;
import com.example.sebastian.reservalabapp.fragments.HoursFragment;

/**
 * Created by sebastian on 08-02-2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;


    public PagerAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new HomeFragment();
            case 1:
                return new HoursFragment();
            case 3:
                return new GetHoursFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
