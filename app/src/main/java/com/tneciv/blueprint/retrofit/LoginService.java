package com.tneciv.blueprint.retrofit;

import com.tneciv.blueprint.entity.LoginEntity;

import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-09-17 19:03 .
 */

public interface LoginService {

    @POST("oauth/token")
    Observable<LoginEntity> login(@Field("client_id") String cliendId, @Field("client_secret") String clientSecret, @Field("code") String code, @Field("redirect_uri") String redirectUri);

}
