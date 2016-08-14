package com.tneciv.dribbble.common;

import com.tneciv.dribbble.entity.ShotEntity;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 18:15 .
 */
public interface ShotService {
    @GET("shots")
    Observable<ShotEntity[]> getShotList();

    @POST("shots")
    Observable<ShotEntity> createBucket(@Field("name") String name, @Field("description") String desc);

    @PUT("shots/{id}")
    Observable<ShotEntity> updateBucket(@Path("id") int bucketId, @Field("name") String name, @Field("description") String desc);
}
