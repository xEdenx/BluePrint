package com.tneciv.dribbble.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.dribbble.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tneciv
 * on 2016-08-16 23:21 .
 * Fragment with SwipeRefreshLayout & RecyclerView .
 */

public abstract class BaseListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    public SwipeRefreshLayout refreshLayout;

    public BaseListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        int colorAccent = getResources().getColor(R.color.colorAccent);
        int colorPrimary = getResources().getColor(R.color.colorPrimary);
        int colorPrimaryDark = getResources().getColor(R.color.colorPrimaryDark);
        refreshLayout.setColorSchemeColors(colorAccent, colorPrimary, colorPrimaryDark);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }

    protected abstract void initRecyclerView();

    @Override
    public void onRefresh() {

    }
}
