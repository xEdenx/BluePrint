package com.tneciv.blueprint.module.comments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.common.utils.CheckUtils;
import com.tneciv.blueprint.entity.CommentEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A fragment to show comments in ShotActivity .
 */
public class CommentsFragment extends Fragment implements CommentsContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.scrollView)
    ObservableScrollView mScrollView;

    private int shotId;
    private List<CommentEntity> mEntityList;
    private CommentsAdapter adapter;
    private CommentsContract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            shotId = getArguments().getInt(Constants.SHOT_ID);
        }
        mEntityList = new ArrayList<>();
        new CommentsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        ButterKnife.bind(this, view);
        adapter = new CommentsAdapter(this, mEntityList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (shotId != 0) {
            mPresenter.getComments(shotId);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unsubscribe();
    }

    public CommentsFragment() {
    }

    public static CommentsFragment newInstance(int id) {
        CommentsFragment fragment = new CommentsFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.SHOT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(CommentsContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult(CommentEntity[] entities) {
        mEntityList.clear();
        mEntityList.addAll(Arrays.asList(entities));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void handleError(Throwable e) {
        Snackbar.make(mScrollView, CheckUtils.checkString(e.getMessage()), Snackbar.LENGTH_SHORT).setAction("refresh", v -> onResume()).show();
    }
}
