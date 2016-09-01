package com.tneciv.blueprint.module.popular;

import com.tneciv.blueprint.base.BasePresenterImpl;
import com.tneciv.blueprint.entity.UserEntity;
import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.UserService;

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
    public void subscribe() {
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
    public void unsubscribe() {
        super.onUnsubscribe();
    }
}
