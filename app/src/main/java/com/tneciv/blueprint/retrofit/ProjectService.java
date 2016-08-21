package com.tneciv.blueprint.retrofit;

import com.tneciv.blueprint.entity.ProjectEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-15 18:11 .
 */
public interface ProjectService {
    @GET("projects/{id}")
    Observable<ProjectEntity> getProject(@Path("id") int projectId);
}
