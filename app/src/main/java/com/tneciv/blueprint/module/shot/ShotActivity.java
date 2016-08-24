package com.tneciv.blueprint.module.shot;

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

public class ShotActivity extends AppCompatActivity {

    @BindView(R.id.imgContent)
    ImageView imgContent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contentArea)
    FrameLayout contentArea;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    private ShotEntity shotEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        loadData();
        initView();
    }

    @Override
    protected void onResume() {
        final String title = shotEntity.getTitle();
        if (!TextUtils.isEmpty(shotEntity.getImages().getHidpi())) {
            Picasso.with(this).load(shotEntity.getImages().getHidpi()).into(imgContent);
        }
        super.onResume();
    }

    private void loadData() {

        if (this.getIntent() != null) {
            this.shotEntity = getIntent().getParcelableExtra(Constants.SHOT_ENTITY);
        } else {
            // TODO: 8-23-0023  get Shot form net by Id
        }

    }


    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
