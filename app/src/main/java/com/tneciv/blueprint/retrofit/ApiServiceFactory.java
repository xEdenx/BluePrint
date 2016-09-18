package com.tneciv.blueprint.retrofit;

import android.util.Log;

import com.github.florent37.materialviewpager.BuildConfig;
import com.tneciv.blueprint.BluePrintApp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tneciv
 * on 2016-08-14 19:57 .
 */

public class ApiServiceFactory {

    private static final String DEFAULT_BASE_URL = "https://api.dribbble.com/v1/";
    private static volatile Retrofit defaultInstance;
    private static String TOKEN = "2074bbbaf8bae6866417a528f69780929ab6c61732473096719ef4cf210ea3be";

    private ApiServiceFactory() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    public static Retrofit getInstance(String... url) {
        String baseUrl = url.length > 0 ? url[0] : DEFAULT_BASE_URL;

        if (BuildConfig.DEBUG) Log.d("Factory baseUrl", baseUrl);

        if (defaultInstance == null) {
            synchronized (Retrofit.class) {
                if (defaultInstance == null) {

                    OkHttpClient.Builder builder = BluePrintApp.getOkhttpBuilder();

                    /**
                     * Okhttp 请求拦截器
                     */
                    Interceptor mTokenInterceptor = chain -> {
                        Request originalRequest = chain.request();
                        Request authorised = originalRequest.newBuilder()
                                .header("Authorization", "Bearer " + TOKEN)
                                .build();
                        return chain.proceed(authorised);
                    };
                    builder.addInterceptor(mTokenInterceptor);

                    OkHttpClient okHttpClient = builder.build();

                    defaultInstance = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();

                }
            }
        }

        return defaultInstance;
    }

}
