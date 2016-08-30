package com.tneciv.blueprint.retrofit;

import com.tneciv.blueprint.entity.CommentEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-30 12:41 .
 */

public interface CommentsService {
    @GET("shots/{shotId}/comments?page=2&per_page=30")
    Observable<CommentEntity[]> getComments(@Path("shotId") int shotId);
}
