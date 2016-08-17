package com.tneciv.dribbble.module.shot;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.tneciv.dribbble.base.BaseListFragment;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShotFragment extends BaseListFragment implements ShotContract.View {
    private ShotContract.Presenter mPresenter;
    private List<ShotEntity> list = new ArrayList<>();
    private ShotRecyclerAdapter recyclerAdapter;

    public ShotFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshLayout.setRefreshing(true);
        mPresenter.start();
    }

    @Override
    protected void initRecyclerView() {
        recyclerAdapter = new ShotRecyclerAdapter(getActivity(), list);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        mPresenter.start();
    }

    @Override
    public void setPresenter(ShotContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(ShotEntity[] shotEntities) {
        refreshLayout.setRefreshing(false);
        list.clear();
        list.addAll(Arrays.asList(shotEntities));
        recyclerAdapter.notifyDataSetChanged();
        Log.d("shotEntities:" + list.size(), "ShotFragment");
    }
}
