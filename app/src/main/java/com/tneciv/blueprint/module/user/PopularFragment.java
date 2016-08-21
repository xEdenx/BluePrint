package com.tneciv.blueprint.module.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tneciv.blueprint.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment implements PopularContract.View {

    @BindView(R.id.tv_result)
    TextView tvResult;
    private PopularContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this, view);

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

    public PopularFragment() {
    }

    @Override
    public void showResponse(String response) {
        Log.d("PopularFragment", response);
        tvResult.setText(response);
    }

    @Override
    public void setPresenter(PopularContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
