package com.tneciv.blueprint.module.trend;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.tneciv.blueprint.base.BaseListFragment;
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
import static com.tneciv.blueprint.common.Constants.SORT_TYPE_VIEWS;


/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 * A fragment to show shots list .
 */
public abstract class TrendFragment extends BaseListFragment implements TrendContract.View, TrendRecyclerAdapter.PaginationListener {

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

    public TrendFragment() {
    }

    @Override
    protected void initRecyclerView() {
        list = new ArrayList<>();
        recyclerAdapter = new TrendRecyclerAdapter(getActivity(), list);
        recyclerAdapter.addPaginationListener(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(setLayoutManager(getActivity()));
    }

    @Override
    public void onRefresh() {
        mPresenter.getShotList(initOptionMap());
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
        mPresenter.loadMore(currentPage, totalRecord, SORT, SORT_TYPE_VIEWS);
    }

    /**
     * set layoutManager of RecyclerView .
     *
     * @param context
     * @return LayoutManager
     */
    public abstract RecyclerView.LayoutManager setLayoutManager(Context context);

    /**
     * set the optionMap to get shots .
     *
     * @return optionMap .
     */
    public abstract Map<String, String> initOptionMap();

    /**
     * optionMap with default pageNum , pageSize .
     * used to return a default map for initOptionMap() .
     *
     * @param sortType  to get Shots
     * @param trendType to get Shots
     * @return default optionMap .
     */
    public Map<String, String> defaultOptionMap(String sortType, String trendType) {
        Map<String, String> map = new HashMap<>();
        //map.put(SORT, SORT_TYPE_VIEWS);
        map.put(sortType, trendType);
        map.put(PAGE, "1");
        map.put(PER_PAGE, String.valueOf(PAGE_SIZE));
        return map;
    }

}
