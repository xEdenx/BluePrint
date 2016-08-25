package com.tneciv.blueprint.module.shot;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShotActivity extends AppCompatActivity implements ShotContract.View {

    @BindView(R.id.imgContent)
    ImageView imgContent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contentArea)
    FrameLayout contentArea;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private ShotContract.Presenter mPresenter;
    private ShotEntity mShotEntity;
    private int shotId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

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
        if (this.getIntent() != null) {
            this.mShotEntity = getIntent().getParcelableExtra(Constants.SHOT_ENTITY);
        } else {
            mPresenter.loadData(shotId);
        }
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setPresenter(ShotContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showResult(ShotEntity entity) {
        if (entity != null) {
            String title = entity.getTitle();
            if (!TextUtils.isEmpty(entity.getImages().getHidpi())) {
                Picasso.with(this).load(entity.getImages().getHidpi()).into(imgContent);
            }
        }
    }
}
