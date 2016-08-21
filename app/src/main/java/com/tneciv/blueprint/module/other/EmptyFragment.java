package com.tneciv.blueprint.module.other;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.widget.BluePrintRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyFragment extends Fragment implements EmptyContract.View {

    private EmptyAdapter mAdapter;
    private List<ShotEntity> list;
    private EmptyContract.Presenter mPresenter;

    public EmptyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list = new ArrayList<>();
        mAdapter = new EmptyAdapter(getActivity(), list);

        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        BluePrintRecyclerView recyclerView =
                (BluePrintRecyclerView) view.findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setEmptyView(view.findViewById(R.id.emptyView));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.unsubscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void showList(ShotEntity[] shotEntities) {
        list.clear();
        list.addAll(Arrays.asList(shotEntities));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void setPresenter(EmptyContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
