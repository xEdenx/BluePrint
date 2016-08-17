package com.tneciv.dribbble.module.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.module.shot.ShotFragment;
import com.tneciv.dribbble.module.shot.ShotPresenter;

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

    /*
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public static MainFragment newInstance(String param1, String param2) {
    MainFragment fragment = new MainFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this, view);

        initViewPager();

        return view;
    }

    private void initViewPager() {
        Fragment[] fragments = {new ShotFragment(), new PopularFragment()};
        List<Fragment> fragmentList = Arrays.asList(fragments);
        String[] titles = {"AAA", "BBB"};
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getChildFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        new ShotPresenter((ShotFragment) pagerAdapter.getItem(0));
        new MainPresenter((PopularFragment) pagerAdapter.getItem(1));
    }

}
