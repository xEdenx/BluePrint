package com.tneciv.blueprint.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.widget.BluePrintRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tneciv
 * on 2016-08-16 23:21 .
 * Fragment with SwipeRefreshLayout & RecyclerView .
 */

public abstract class BaseListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    public BluePrintRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    public SwipeRefreshLayout refreshLayout;
    @BindView(R.id.emptyView)
    public RelativeLayout emptyView;
    @BindView(R.id.btnEmpty)
    public Button btnEmpty;

    public int currentPage;
    public int totalRecord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        int colorAccent = ContextCompat.getColor(getActivity(), R.color.colorAccent);
        int colorPrimary = ContextCompat.getColor(getActivity(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark);
        refreshLayout.setColorSchemeColors(colorAccent, colorPrimary, colorPrimaryDark);

        refreshLayout.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);

        initView();
        initRecyclerView();

        return view;
    }

    public BaseListFragment() {
    }

    protected void initView() {
        recyclerView.setEmptyView(emptyView);
        btnEmpty.setText("loading ...");
        btnEmpty.setOnClickListener(view -> Toast.makeText(getActivity(), "oh ...", Toast.LENGTH_SHORT).show());
    }

    protected ActionBar getToolbar(Activity activity) {
        return ((AppCompatActivity) activity).getSupportActionBar();
    }

    protected abstract void initRecyclerView();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            onRefresh();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.base, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
