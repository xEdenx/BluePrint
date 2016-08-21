package com.tneciv.blueprint.retrofit;

import com.tneciv.blueprint.entity.BucketEntity;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 17:55 .
 */
public interface BucketsService {

    @GET("buckets/{id}")
    Observable<BucketEntity> getBucket(@Path("id") int bucketId);

    @POST("buckets")
    Observable<BucketEntity> createBucket(@Field("name") String name, @Field("description") String desc);

    @PUT("buckets/{id}")
    Observable<BucketEntity> updateBucket(@Path("id") int bucketId, @Field("name") String name, @Field("description") String desc);

}
