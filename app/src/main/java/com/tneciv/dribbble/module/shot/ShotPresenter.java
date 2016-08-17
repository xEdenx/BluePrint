package com.tneciv.dribbble.module.shot;

import com.tneciv.dribbble.base.BasePresenterImpl;
import com.tneciv.dribbble.common.ApiServiceFactory;
import com.tneciv.dribbble.common.ShotService;
import com.tneciv.dribbble.entity.ShotEntity;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-17 18:20 .
 */
public class ShotPresenter extends BasePresenterImpl implements ShotContract.Presenter {
    private ShotContract.View mView;

    public ShotPresenter(ShotContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        final ShotService shotService = ApiServiceFactory.getInstance().create(ShotService.class);
        final Observable<ShotEntity[]> shotList = shotService.getShotList();
        addSubscription(shotList, new Subscriber<ShotEntity[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShotEntity[] shotEntities) {
                mView.showList(shotEntities);
            }
        });
    }
}
