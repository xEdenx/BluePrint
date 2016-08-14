package com.tneciv.dribbble.module.main;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initFragment() {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            mainFragment = new MainFragment();
            addFragmentToActivity(getSupportFragmentManager(), mainFragment);
        }
        new MainPresenter(mainFragment);
    }

}
