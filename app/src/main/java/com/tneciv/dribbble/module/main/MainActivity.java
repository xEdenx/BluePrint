package com.tneciv.dribbble.module.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final int PERMISSION_REQUEST_CODE = 000;

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
            if (checkSelfPermission(
                    Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                requestPermissions(new String[]{
                        Manifest.permission.INTERNET,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                }, PERMISSION_REQUEST_CODE);
            } else {
                start();
            }
        } else {
            start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            int count = 0;

            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    count++;
                    Log.d("BaseActivity", "permissions count:" + count);
                    if (count == grantResults.length) {
                        start();
                    }
                } else {
                    Log.e("MainActivity", "PERMISSION REQUEST FAILED !!!");
                    Toast.makeText(this, "权限被拒绝，将不能缓存本地数据.", Toast.LENGTH_SHORT)
                            .show();
                }
            }

        }
    }

}
