package com.tneciv.blueprint.module.shot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.module.comments.CommentsFragment;
import com.tneciv.blueprint.module.intro.IntroFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShotActivity extends AppCompatActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewpager;
    private Toolbar mToolbar;
    private PagerAdapter mAdapter;
    private ShotEntity mShotEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        handleIntent();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void handleIntent() {
        Intent intent = getIntent();

        if (this.getIntent() != null) {
            this.mShotEntity = intent.getParcelableExtra(Constants.SHOT_ENTITY);
        }

        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            String url = intent.getDataString();
            if (!TextUtils.isEmpty(url)) {
                Log.d("ShotActivity url", url);
            }
        }

    }

    private void initView() {
        mToolbar = mViewpager.getToolbar();
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        setTitle("");
        String[] titles = {"desc", "comments"};
        IntroFragment introFragment = IntroFragment.newInstance(mShotEntity);
        int mShotEntityId = mShotEntity.getId();
        CommentsFragment fragment = CommentsFragment.newInstance(mShotEntityId);
        Fragment[] fragments = {introFragment, fragment};
        ShotEntity.ImagesBean images = mShotEntity.getImages();

        String imgUrl = !TextUtils.isEmpty(images.getHidpi()) ? images.getHidpi() : images.getNormal();

        mAdapter = new PagerAdapter(getSupportFragmentManager(), titles, Arrays.asList(fragments));
        ViewPager pager = mViewpager.getViewPager();

        pager.setAdapter(mAdapter);
        mViewpager.setMaterialViewPagerListener(page -> HeaderDesign.fromColorResAndUrl(R.color.colorAccent,
                imgUrl));
        pager.setOffscreenPageLimit(pager.getAdapter().getCount());
        mViewpager.getPagerTitleStrip()
                .setViewPager(pager);
    }

    class PagerAdapter extends FragmentStatePagerAdapter {
        private String[] mTitles;
        private List<Fragment> mFragmentList;

        PagerAdapter(FragmentManager fm, String[] titles, List<Fragment> list) {
            super(fm);
            this.mTitles = titles;
            this.mFragmentList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
