package com.tneciv.dribbble.common;

import com.tneciv.dribbble.entity.UserEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 18:24 .
 */
public interface TeamService {
    @GET("teams/{team}/members")
    Observable<UserEntity[]> getMemberList(@Path("team") String teamName);
}
