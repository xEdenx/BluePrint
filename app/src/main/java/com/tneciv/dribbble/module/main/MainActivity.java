package com.tneciv.dribbble.module.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.tneciv.dribbble.base.BaseActivity;
import com.tneciv.dribbble.module.shot.ShotFragment;
import com.tneciv.dribbble.module.shot.ShotPresenter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void initFragment() {
        ShotFragment shotFragment = (ShotFragment) pagerAdapter.getItem(0);
        MainFragment mainFragment = (MainFragment) pagerAdapter.getItem(1);
        new ShotPresenter(shotFragment);
        new MainPresenter(mainFragment);
    }

    @Override
    protected void initViewPager() {
        Fragment[] fragments = {new ShotFragment(), new MainFragment()};
        List<Fragment> fragmentList = Arrays.asList(fragments);
        String[] titles = {"AAA", "BBB"};
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

}
