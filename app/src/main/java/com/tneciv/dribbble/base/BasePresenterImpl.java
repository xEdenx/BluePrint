package com.tneciv.dribbble.base;

import com.tneciv.dribbble.common.RestClient;
import com.tneciv.dribbble.common.RestService;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tneciv
 * on 2016-08-14 23:21 .
 * Presenter 公共方法及属性集合
 */

public class BasePresenterImpl {
    private CompositeSubscription mCompositeSubscription;
    private RestService restService = RestClient.retrofit().create(RestService.class);

    /**
     * RxJava取消注册，以避免内存泄露
     * call when onDestory or detachView
     */
    protected void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    protected RestService getRestService() {
        return this.restService;
    }
}
