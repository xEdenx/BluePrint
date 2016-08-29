package com.tneciv.blueprint.module.shot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

import butterknife.ButterKnife;

public class ShotActivity extends AppCompatActivity implements ShotContract.View {

    private ShotContract.Presenter mPresenter;
    private ShotEntity mShotEntity;
    private int shotId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initView();
        new ShotPresenter(this);
        handleIntent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showResult(mShotEntity);
    }

    private void handleIntent() {
        final Intent intent = getIntent();

        if (this.getIntent() != null) {
            this.mShotEntity = intent.getParcelableExtra(Constants.SHOT_ENTITY);
        } else {
            //mPresenter.loadData(shotId);
        }

        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            final String url = intent.getDataString();
            if (!TextUtils.isEmpty(url)) {
                Log.d("ShotActivity url", url);
            }
        }

    }

    private void initView() {

    }

    @Override
    public void setPresenter(ShotContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showResult(ShotEntity entity) {

    }
}
