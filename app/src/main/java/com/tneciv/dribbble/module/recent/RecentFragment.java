package com.tneciv.dribbble.module.recent;


import android.support.v7.widget.LinearLayoutManager;

import com.tneciv.dribbble.base.BaseListFragment;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tneciv.dribbble.common.Constants.PAGE_SIZE;
import static com.tneciv.dribbble.common.Constants.SORT_TYPE_VIEWS;


/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 * A fragment to show shots list .
 */
public class RecentFragment extends BaseListFragment implements RecentContract.View, RecentRecyclerAdapter.PaginationListener {

    private RecentContract.Presenter mPresenter;
    private List<ShotEntity> list;
    private RecentRecyclerAdapter recyclerAdapter;

    private boolean isCreated;

    @Override
    public void onResume() {
        super.onResume();
        if (!isCreated) {
            onRefresh();
        }
    }

    public RecentFragment() {
    }

    @Override
    protected void initRecyclerView() {
        list = new ArrayList<>();
        recyclerAdapter = new RecentRecyclerAdapter(getActivity(), list);
        recyclerAdapter.addPaginationListener(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.unsubscribe();
        recyclerAdapter.removePaginationListener();
        recyclerAdapter = null;
    }

    @Override
    public void onRefresh() {
        showLoading();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(RecentContract.Presenter presenter) {
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
    public void showEmptyView() {
    }

    @Override
    public void onChange(int position) {
        currentPage = position / PAGE_SIZE + 1;
        mPresenter.loadMore(currentPage, PAGE_SIZE, totalRecord, SORT_TYPE_VIEWS);
    }


}
