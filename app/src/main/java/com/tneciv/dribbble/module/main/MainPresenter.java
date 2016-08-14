package com.tneciv.dribbble.module.main;

import android.content.Context;

import com.tneciv.dribbble.base.BasePresenterImpl;
import com.tneciv.dribbble.entity.StoryEntity;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-14 16:02 .
 */

class MainPresenter extends BasePresenterImpl implements MainContract.Presenter {
    private Context mContext;
    private MainContract.View mView;

    MainPresenter(Context context, MainContract.View view) {
        this.mContext = context;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        final Observable<StoryEntity> storyRx = getRestService().getStoryRx(8863);
        addSubscription(storyRx, new Subscriber<StoryEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StoryEntity storyEntity) {
                mView.showResponse(storyEntity.toString());
            }
        });

    }

    @Override
    public void unSubscribe() {
        super.onUnsubscribe();
    }
}
