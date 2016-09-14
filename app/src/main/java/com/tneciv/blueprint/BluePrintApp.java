package com.tneciv.blueprint;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tneciv.blueprint.common.OkhttpFacade;
import com.tneciv.blueprint.common.utils.IMMLeaks;

import okhttp3.OkHttpClient;

/**
 * Created by Tneciv
 * on 2016-08-19 22:51 .
 */

public class BluePrintApp extends Application {

    private static OkHttpClient.Builder sBuilder;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        sBuilder = OkhttpFacade.getInstance(getApplicationContext());
        IMMLeaks.fixFocusedViewLeak(this);
    }

    public static OkHttpClient.Builder getOkhttpBuilder() {
        return BluePrintApp.sBuilder;
    }

}
