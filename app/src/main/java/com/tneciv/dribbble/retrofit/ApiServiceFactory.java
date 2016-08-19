package com.tneciv.dribbble.retrofit;

import com.tneciv.dribbble.BuildConfig;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tneciv
 * on 2016-08-14 19:57 .
 */

public class ApiServiceFactory {

    private static final String BASE_API_URL = "https://api.dribbble.com/v1/";
    private static final String TOKEN = "Bearer 2074bbbaf8bae6866417a528f69780929ab6c61732473096719ef4cf210ea3be";
    private static volatile Retrofit defaultInstance;

    private ApiServiceFactory() throws InstantiationException {
        throw new InstantiationException("This class is not for instantiation");
    }

    public static Retrofit getInstance() {

        if (defaultInstance == null) {
            synchronized (Retrofit.class) {
                if (defaultInstance == null) {

                    OkHttpClient.Builder builder = new OkHttpClient.Builder();

                    /**
                     * Okhttp Log 信息拦截器
                     */
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                        builder.addInterceptor(loggingInterceptor);
                    }

                    Interceptor mTokenInterceptor = chain -> {
                        Request originalRequest = chain.request();
                        Request authorised = originalRequest.newBuilder()
                                .header("Authorization", TOKEN)
                                .build();
                        return chain.proceed(authorised);
                    };

                    builder.addInterceptor(mTokenInterceptor);

                    OkHttpClient okHttpClient = builder.build();
                    defaultInstance = new Retrofit.Builder()
                            .baseUrl(BASE_API_URL)
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
