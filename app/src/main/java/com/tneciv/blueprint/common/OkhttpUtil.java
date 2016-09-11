package com.tneciv.blueprint.common;

import android.content.Context;
import android.os.Environment;

import com.tneciv.blueprint.BuildConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
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
                if (!SystemUtil.isNetworkReachable(context)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                Response response = chain.proceed(request);
                Response responseLast;
                if (SystemUtil.isNetworkReachable(context)) {
                    int maxAge = 0;
                    // when net available , set cache out of date time to 0 .
                    responseLast = response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 28;
                    //  when net not available , set cache out of date time to 4 weeks .
                    responseLast = response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }

                return responseLast;

            };

            // Cache Path
            File httpCacheDirectory = new File(getDiskCachePath(context), "responses");
            // Cache Size
            Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);
            defaultInstance.cache(cache);

            defaultInstance.connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            defaultInstance.readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            defaultInstance.writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            defaultInstance.addInterceptor(cacheInterceptor);
            defaultInstance.addNetworkInterceptor(cacheInterceptor);
            defaultInstance.retryOnConnectionFailure(true);

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
