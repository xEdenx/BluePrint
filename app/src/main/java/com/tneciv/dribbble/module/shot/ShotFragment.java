package com.tneciv.dribbble.module.shot;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.tneciv.dribbble.base.BaseListFragment;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tneciv.dribbble.common.Constants.PAGE_SIZE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShotFragment extends BaseListFragment implements ShotContract.View, ShotRecyclerAdapter.PaginationListener {

    private ShotContract.Presenter mPresenter;
    private List<ShotEntity> list;
    private ShotRecyclerAdapter recyclerAdapter;

    private boolean isCreated;

    @Override
    public void onResume() {
        super.onResume();
        if (!isCreated) {
            onRefresh();
        }
    }

    public ShotFragment() {
    }

    @Override
    protected void initRecyclerView() {
        list = new ArrayList<>();
        recyclerAdapter = new ShotRecyclerAdapter(getActivity(), list);
        recyclerAdapter.addPaginationListener(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onRefresh() {
        showLoading();
        mPresenter.start();
    }

    @Override
    public void setPresenter(ShotContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(ShotEntity[] shotEntities) {
        isCreated = true;
        if (currentPage == 1) {
            list.clear();
            totalRecord = 0;
        }
        totalRecord += shotEntities.length;
        list.addAll(Arrays.asList(shotEntities));
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoad(int position) {
        currentPage = position / PAGE_SIZE + 1;
        mPresenter.loadMore(position, currentPage, PAGE_SIZE, totalRecord);
    }

}
