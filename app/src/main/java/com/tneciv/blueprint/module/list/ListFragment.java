package com.tneciv.blueprint.module.list;


import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseListFragment;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tneciv.blueprint.common.Constants.PAGE_SIZE;
import static com.tneciv.blueprint.common.Constants.SORT_TYPE_VIEWS;


/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 * A fragment to show shots list .
 */
public class ListFragment extends BaseListFragment implements ListContract.View, ListRecyclerAdapter.PaginationListener {

    private ListContract.Presenter mPresenter;
    private List<ShotEntity> list;

    @Override
    public void onResume() {
        super.onResume();
        if (!isCreated) {
            onRefresh();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.unsubscribe();
        recyclerAdapter.removePaginationListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            onRefresh();
        }

        return super.onOptionsItemSelected(item);
    }

    private ListRecyclerAdapter recyclerAdapter;

    private boolean isCreated;

    public ListFragment() {
    }

    @Override
    protected void initRecyclerView() {
        list = new ArrayList<>();
        recyclerAdapter = new ListRecyclerAdapter(getActivity(), list);
        recyclerAdapter.addPaginationListener(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onRefresh() {
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
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
    public void showError() {
    }

    @Override
    public void onChange(int position) {
        currentPage = position / PAGE_SIZE + 1;
        mPresenter.loadMore(currentPage, PAGE_SIZE, totalRecord, SORT_TYPE_VIEWS);
    }

}
