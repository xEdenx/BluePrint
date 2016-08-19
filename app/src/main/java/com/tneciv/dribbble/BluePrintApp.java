package com.tneciv.dribbble;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Tneciv
 * on 2016-08-19 22:51 .
 */

public class BluePrintApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
