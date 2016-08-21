package com.tneciv.blueprint.base;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tneciv
 * on 2016-08-14 23:21 .
 * Presenter 公共方法及属性集合，与 BasePresenter 无关，供 *Presenter 继承
 */

public class BasePresenterImpl {

    private CompositeSubscription mCompositeSubscription;

    /**
     * RxJava 取消注册，以避免内存泄露
     * call in Activity.onDestory() or Fragment.detachView()
     */
    protected void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
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

}
