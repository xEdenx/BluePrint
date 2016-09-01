package com.tneciv.blueprint.module.trend;


import android.support.v7.widget.LinearLayoutManager;

import com.tneciv.blueprint.base.BaseListFragment;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tneciv.blueprint.common.Constants.PAGE;
import static com.tneciv.blueprint.common.Constants.PAGE_SIZE;
import static com.tneciv.blueprint.common.Constants.PER_PAGE;
import static com.tneciv.blueprint.common.Constants.SORT;
import static com.tneciv.blueprint.common.Constants.SORT_VIEWS;


/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 * A fragment to show shots list .
 */
public class MostViewsFragment extends BaseListFragment implements TrendContract.View, TrendRecyclerAdapter.PaginationListener {

    private TrendContract.Presenter mPresenter;
    private List<ShotEntity> list;

    @Override
    public void onResume() {
        super.onResume();
        if (!isCreated) {
            onRefresh();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unsubscribe();
        recyclerAdapter.removePaginationListener();
    }

    private TrendRecyclerAdapter recyclerAdapter;

    private boolean isCreated;

    public MostViewsFragment() {
    }

    @Override
    protected void initRecyclerView() {
        list = new ArrayList<>();
        recyclerAdapter = new TrendRecyclerAdapter(getActivity(), list);
        recyclerAdapter.addPaginationListener(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onRefresh() {
        Map<String, String> options = new HashMap<>();
        options.put(SORT, SORT_VIEWS);
        options.put(PAGE, "1");
        options.put(PER_PAGE, String.valueOf(PAGE_SIZE));
        mPresenter.getShotList(options);
    }

    @Override
    public void setPresenter(TrendContract.Presenter presenter) {
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
    public void showError(Throwable throwable) {
    }

    @Override
    public void onChange(int position) {
        currentPage = position / PAGE_SIZE + 1;
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.SHOTS_NAME, Constants.SORT);
        map.put(Constants.SHOTS_TYPE, SORT_VIEWS);
        mPresenter.loadMore(currentPage, totalRecord, map);
    }

}
