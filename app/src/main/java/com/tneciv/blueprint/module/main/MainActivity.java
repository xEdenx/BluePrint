package com.tneciv.blueprint.module.main;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseActivity;
import com.tneciv.blueprint.common.utils.SystemUtil;

public class MainActivity extends BaseActivity {

    private static final int PERMISSION_REQUEST_CODE = 1000;

    @Override
    protected void initFragment() {
        askForPermissions();
    }

    private void start() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, new MainFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commitAllowingStateLoss();
    }

    private void askForPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            SystemUtil.checkPermissions(this, PERMISSION_REQUEST_CODE);
        } else {
            start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            int count = 1;
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    count++;
                }
            }
            if (count != grantResults.length) {
                Snackbar.make(contentFrame, getString(R.string.permission_notice), Snackbar.LENGTH_SHORT)
                        .setAction("empower", v -> askForPermissions())
                        .show();
            }
            start();
        }
    }

}
