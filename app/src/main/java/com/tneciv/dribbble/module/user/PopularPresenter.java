package com.tneciv.dribbble.module.user;

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

public class PopularPresenter extends BasePresenterImpl implements PopularContract.Presenter {
    private PopularContract.View mView;

    public PopularPresenter(PopularContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        UserService apiService = ApiServiceFactory.getInstance().create(UserService.class);
        Observable<UserEntity> user = apiService.getUser("simplebits");
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
