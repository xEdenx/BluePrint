package com.tneciv.dribbble.retrofit;

import com.tneciv.dribbble.entity.ShotEntity;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 18:15 .
 */
public interface ShotService {

    @GET("shots")
    Observable<ShotEntity[]> getShotListWithQueryMap(@QueryMap Map<String, String> options);

    @POST("shots")
    Observable<ShotEntity> createBucket(@Field("name") String name, @Field("description") String desc);

    @PUT("shots/{id}")
    Observable<ShotEntity> updateBucket(@Path("id") int bucketId, @Field("name") String name, @Field("description") String desc);
}
