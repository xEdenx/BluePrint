package com.tneciv.dribbble.module.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-17 15:14 .
 */

class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private String[] mTitles;

    MainPagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.fragmentList = list;
        this.mTitles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
