package com.tneciv.blueprint.module.shot;

import com.tneciv.blueprint.base.BasePresenterImpl;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.ShotService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-23 21:41 .
 */

class ShotPresenter extends BasePresenterImpl implements ShotContract.Presenter {
    private ShotContract.View mView;

    ShotPresenter(ShotContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        super.onUnsubscribe();
    }

    @Override
    public void loadData(int id) {
        ShotService shotService = ApiServiceFactory.getInstance().create(ShotService.class);
        Observable<ShotEntity> entityObservable = shotService.getShot(id);
        addSubscription(entityObservable, new Subscriber<ShotEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShotEntity entity) {
                mView.showResult(entity);
            }
        });
    }
}
