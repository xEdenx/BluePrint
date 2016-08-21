package com.tneciv.blueprint.module.other;

import com.tneciv.blueprint.base.BasePresenterImpl;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.ShotService;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

import static com.tneciv.blueprint.common.Constants.PAGE;
import static com.tneciv.blueprint.common.Constants.PAGE_SIZE;
import static com.tneciv.blueprint.common.Constants.PER_PAGE;
import static com.tneciv.blueprint.common.Constants.SORT;
import static com.tneciv.blueprint.common.Constants.SORT_TYPE_VIEWS;

/**
 * Created by Tneciv
 * on 2016-08-17 18:20 .
 */
public class EmptyPresenter extends BasePresenterImpl implements EmptyContract.Presenter {

    private EmptyContract.View mView;

    public EmptyPresenter(EmptyContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        HashMap<String, String> options = new HashMap<>();
        options.put(SORT, SORT_TYPE_VIEWS);
        options.put(PAGE, "1");
        options.put(PER_PAGE, String.valueOf(PAGE_SIZE));
        getShotList(options);
    }

    @Override
    public void unsubscribe() {
        super.onUnsubscribe();
    }

    @Override
    public void getShotList(Map<String, String> options) {
        ShotService shotService = ApiServiceFactory.getInstance().create(ShotService.class);
        Observable<ShotEntity[]> shotList = shotService.getShotListWithQueryMap(options);
        super.addSubscription(shotList, new Subscriber<ShotEntity[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showEmptyView();
            }

            @Override
            public void onNext(ShotEntity[] shotEntities) {
                mView.showList(shotEntities);
            }
        });
    }

}
