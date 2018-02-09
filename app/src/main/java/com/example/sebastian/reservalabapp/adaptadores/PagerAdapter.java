package com.example.sebastian.reservalabapp.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sebastian.reservalabapp.fragments.tab_fragments.GetHoursFragment;
import com.example.sebastian.reservalabapp.fragments.tab_fragments.HomeFragment;
import com.example.sebastian.reservalabapp.fragments.tab_fragments.HoursFragment;

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
        Fragment frg = null;
        switch (position){

            case 0:
                return new HomeFragment();
            case 1:
                return new HoursFragment();
            case 2:
                return new GetHoursFragment();
        }
        return frg;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
