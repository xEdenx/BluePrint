package com.tneciv.blueprint;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tneciv.blueprint.common.IMMLeaks;
import com.tneciv.blueprint.common.OkhttpUtil;

import okhttp3.OkHttpClient;

/**
 * Created by Tneciv
 * on 2016-08-19 22:51 .
 */

public class BluePrintApp extends Application {

    private static OkHttpClient.Builder builder;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        builder = OkhttpUtil.getInstance(getApplicationContext());
        IMMLeaks.fixFocusedViewLeak(this);
    }

    public static OkHttpClient.Builder getOkhttpBuilder() {
        return BluePrintApp.builder;
    }

}
