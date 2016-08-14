package com.tneciv.dribbble.module.other;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.base.BaseActivity;

public class OtherActivity extends BaseActivity {

    @Override
    protected void initFragment() {
        OtherFragment fragment =
                (OtherFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (fragment == null) {
            fragment = new OtherFragment();
            addFragmentToActivity(getSupportFragmentManager(), fragment);
        }

    }
}
