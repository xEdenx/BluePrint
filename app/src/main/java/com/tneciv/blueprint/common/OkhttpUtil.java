package com.tneciv.blueprint.common;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.tneciv.blueprint.BuildConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Tneciv
 * on 2016-09-11 15:24 .
 */

public class OkhttpUtil {

    private static volatile OkHttpClient.Builder defaultInstance;
    private static final int TIMEOUT_SECONDS = 30;

    private OkhttpUtil() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    public static OkHttpClient.Builder getInstance(Context context) {
        if (defaultInstance == null) {
            synchronized (OkHttpClient.Builder.class) {
                if (defaultInstance == null) {
                    defaultInstance = new OkHttpClient.Builder();
                }
            }

            /**
             * Okhttp Log 信息拦截器
             */
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                defaultInstance.addInterceptor(loggingInterceptor);
            }

            /**
             * Okhttp 缓存拦截器
             */
            Interceptor cacheInterceptor = chain -> {
                Request request = chain.request();
                if (BuildConfig.DEBUG) Log.i("ApiServiceFactory", "request=" + request);
                Response response = chain.proceed(request);
                if (BuildConfig.DEBUG) Log.i("Cache", "response=" + response);

                String cacheControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(cacheControl)) {
                    cacheControl = "public, max-age=60";
                }
                return response.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            };

            // Cache Path
            File httpCacheDirectory = new File(getDiskCachePath(context), "responses");
            // Cache Size
            Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);
            defaultInstance.addNetworkInterceptor(cacheInterceptor);
            defaultInstance.connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            defaultInstance.cache(cache);

        }
        return defaultInstance;
    }

    private static String getDiskCachePath(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getPath();
        } else {
            return context.getCacheDir().getPath();
        }
    }

}
