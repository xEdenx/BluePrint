package com.tneciv.blueprint.module.shot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShotActivity extends AppCompatActivity {

    @BindView(R.id.imgContent)
    ImageView imgContent;
    @BindView(R.id.custTitle)
    TextView custTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contentArea)
    FrameLayout contentArea;
    private ShotEntity shotEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        loadData();
        initView();
    }

    @Override
    protected void onResume() {
        final String title = shotEntity.getTitle();
        custTitle.setText(title);
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
