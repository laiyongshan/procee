package com.yeohe.proceeds.ui.custom;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private int size;
    private ArrayList<Fragment> fragments;

    public MyViewPagerAdapter(ArrayList<Fragment> fragments,FragmentManager fm, int size) {
        super(fm);
        this.size = size;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return size;
    }
}
