package com.tneciv.blueprint.module.trend;

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

/**
 * Created by Tneciv
 * on 2016-08-17 18:20 .
 */
public class TrendPresenter extends BasePresenterImpl implements TrendContract.Presenter {

    private TrendContract.View mView;

    public TrendPresenter(TrendContract.View view) {
        this.mView = view;
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
    public void loadMore(int currentPage, int totalRecord, String sortType, String trendType) {
        if (currentPage > totalRecord / PAGE_SIZE) {
            Map<String, String> map = new HashMap<>();
            map.put(sortType, trendType);
            map.put(PAGE, String.valueOf(currentPage));
            map.put(PER_PAGE, String.valueOf(PAGE_SIZE));
            getShotList(map);
        }
    }

    @Override
    public void getShotList(Map<String, String> options) {
        mView.showLoading();
        ShotService shotService = ApiServiceFactory.getInstance().create(ShotService.class);
        Observable<ShotEntity[]> shotList = shotService.getShotListWithQueryMap(options);
        super.addSubscription(shotList, new Subscriber<ShotEntity[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.showError(e);
            }

            @Override
            public void onNext(ShotEntity[] shotEntities) {
                mView.hideLoading();
                mView.showList(shotEntities);
            }
        });
    }

}
