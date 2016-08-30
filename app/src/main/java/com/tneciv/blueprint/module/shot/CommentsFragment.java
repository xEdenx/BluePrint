package com.tneciv.blueprint.module.shot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.cardContainer)
    CardView cardContainer;
    @BindView(R.id.scrollView)
    ObservableScrollView mScrollView;

    private int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(Constants.SHOT_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.for_test, container, false);
        ButterKnife.bind(this, view);
        ShotEntity dd = new ShotEntity();
        dd.setId(111);
        ShotEntity ss = new ShotEntity();
        ss.setId(222);
        ShotEntity[] arr = {dd, ss};
        EmptyAdapter adapter = new EmptyAdapter(getActivity(), Arrays.asList(arr));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
        return view;
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

}
