package com.tneciv.dribbble.module.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.tneciv.dribbble.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_test)
    Button btnTest;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new MainPresenter(this, this);
        btnTest.setOnClickListener(view -> mPresenter.start());
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void openLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showResponse(String response) {
        tvResult.setText(response);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribe();
    }
}
