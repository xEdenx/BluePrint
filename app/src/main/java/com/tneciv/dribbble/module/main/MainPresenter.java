package com.tneciv.dribbble.module.main;

import com.tneciv.dribbble.base.BasePresenterImpl;
import com.tneciv.dribbble.common.UserService;
import com.tneciv.dribbble.common.ApiServiceFactory;
import com.tneciv.dribbble.entity.UserEntity;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-14 16:02 .
 */

class MainPresenter extends BasePresenterImpl implements MainContract.Presenter {
    private MainContract.View mView;

    MainPresenter(MainContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        final UserService apiService = ApiServiceFactory.getInstance().create(UserService.class);
        final Observable<UserEntity> user = apiService.getUser("simplebits");
        addSubscription(user, new Subscriber<UserEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showResponse(e.getMessage());
            }

            @Override
            public void onNext(UserEntity userEntity) {
                mView.showResponse(userEntity.toString());
            }
        });

    }

    @Override
    public void unSubscribe() {
        super.onUnsubscribe();
    }
}
