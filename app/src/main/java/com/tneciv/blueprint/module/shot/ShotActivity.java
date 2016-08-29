package com.tneciv.blueprint.module.shot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.module.other.EmptyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShotActivity extends AppCompatActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager viewPager;
    private Toolbar mToolbar;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initView();
        //handleIntent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //private void handleIntent() {
    //    Intent intent = getIntent();
    //
    //    if (this.getIntent() != null) {
    //        this.mShotEntity = intent.getParcelableExtra(Constants.SHOT_ENTITY);
    //    } else {
    //        //mPresenter.loadData(shotId);
    //    }
    //
    //    if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
    //        String url = intent.getDataString();
    //        if (!TextUtils.isEmpty(url)) {
    //            Log.d("ShotActivity url", url);
    //        }
    //    }
    //
    //}

    private void initView() {
        mToolbar = viewPager.getToolbar();
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        String[] titles = {"aaa"};
        EmptyFragment fragment = new EmptyFragment();
        Fragment[] fragments = {fragment};

        //mAdapter = new PagerAdapter(getSupportFragmentManager(), titles, Arrays.asList(fragments));
        viewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new EmptyFragment();
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "sasdasd";
            }
        });

        viewPager.setMaterialViewPagerListener(page -> HeaderDesign.fromColorResAndUrl(R.color.accent_color,
                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg"));
        viewPager.getViewPager().setOffscreenPageLimit(viewPager.getViewPager().getAdapter().getCount());
        viewPager.getPagerTitleStrip().setViewPager(viewPager.getViewPager());
    }
}
