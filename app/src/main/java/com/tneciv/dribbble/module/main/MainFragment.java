package com.tneciv.dribbble.module.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.module.recent.RecentFragment;
import com.tneciv.dribbble.module.recent.RecentPresenter;
import com.tneciv.dribbble.module.user.PopularFragment;
import com.tneciv.dribbble.module.user.PopularPresenter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends Fragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        initViewPager();

        return view;
    }

    private void initViewPager() {
        Fragment[] fragments = {new RecentFragment(), new PopularFragment()};
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

        new RecentPresenter((RecentFragment) pagerAdapter.getItem(0));
        new PopularPresenter((PopularFragment) pagerAdapter.getItem(1));
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

}
