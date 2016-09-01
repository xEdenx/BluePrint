package com.tneciv.blueprint.module.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.callback.MenuClickListener;
import com.tneciv.blueprint.module.trend.MostViewsFragment;
import com.tneciv.blueprint.module.trend.RecentFragment;
import com.tneciv.blueprint.module.trend.TrendPresenter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends Fragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private MenuClickListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        initViewPager();

        return view;
    }

    public MainFragment() {
    }

    private void initViewPager() {
        Fragment[] fragments = {new MostViewsFragment(), new RecentFragment()};
        List<Fragment> fragmentList = Arrays.asList(fragments);
        int[] tabIcons = {R.drawable.ic_explore, R.drawable.ic_extension};
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }

        new TrendPresenter((MostViewsFragment) pagerAdapter.getItem(0));
        new TrendPresenter((RecentFragment) pagerAdapter.getItem(1));
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fragmentList;

        PagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.fragmentList = list;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mListener != null) {
            mListener.onClick(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void addMenuClickLitener(MenuClickListener listener) {
        this.mListener = listener;
    }
}
