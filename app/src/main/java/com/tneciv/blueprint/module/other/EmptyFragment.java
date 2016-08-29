package com.tneciv.blueprint.module.other;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public EmptyFragment() {
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
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
