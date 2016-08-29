package com.tneciv.blueprint.module.shot;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-29 14:40 .
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTitles;
    private List<Fragment> mFragmentList;

    public PagerAdapter(FragmentManager fm, String[] titles, List<Fragment> list) {
        super(fm);
        this.mTitles = titles;
        this.mFragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
