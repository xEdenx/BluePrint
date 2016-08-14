package com.tneciv.dribbble.common;

import com.tneciv.dribbble.entity.StoryEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Tneciv
 * on 2016-08-14 19:30 .
 */

public interface RestService {

    @GET("topstories.json")
    Observable<int[]> topStoriesRx();

    @GET("item/{storyId}.json")
    Observable<StoryEntity> getStoryRx(@Path("storyId") int storyId);

}
