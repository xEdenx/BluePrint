package com.tneciv.dribbble.retrofit;

import com.tneciv.dribbble.entity.UserEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 11:17 .
 */
public interface UserService {
    @GET("users/{userName}")
    Observable<UserEntity> getUser(@Path("userName") String userName);

    @GET("user")
    Observable<UserEntity> getLocalUser();
}
