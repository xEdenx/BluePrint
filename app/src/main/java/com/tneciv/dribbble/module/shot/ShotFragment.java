package com.tneciv.dribbble.module.shot;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.tneciv.dribbble.R;
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
        final int colorAccent = getResources().getColor(R.color.colorAccent);
        final int colorPrimary = getResources().getColor(R.color.colorPrimary);
        final int colorPrimaryDark = getResources().getColor(R.color.colorPrimaryDark);
        refreshLayout.setColorSchemeColors(colorAccent, colorPrimary, colorPrimaryDark);
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
        Log.d("ShotFragment", "haha");
    }

    @Override
    public void setPresenter(ShotContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(ShotEntity[] shotEntities) {
        refreshLayout.setRefreshing(false);
        List<ShotEntity> entityList = Arrays.asList(shotEntities);
        list.clear();
        list.addAll(entityList);
        recyclerAdapter.notifyDataSetChanged();
        Log.d("shotEntities:" + list.size(), "ShotFragment");
    }
}
