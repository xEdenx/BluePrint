package com.tneciv.dribbble.module.recent;

import com.tneciv.dribbble.base.BasePresenterImpl;
import com.tneciv.dribbble.retrofit.ApiServiceFactory;
import com.tneciv.dribbble.retrofit.ShotService;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

import static com.tneciv.dribbble.common.Constants.PAGE;
import static com.tneciv.dribbble.common.Constants.PAGE_SIZE;
import static com.tneciv.dribbble.common.Constants.PER_PAGE;
import static com.tneciv.dribbble.common.Constants.SORT;
import static com.tneciv.dribbble.common.Constants.SORT_TYPE_VIEWS;

/**
 * Created by Tneciv
 * on 2016-08-17 18:20 .
 */
public class RecentPresenter extends BasePresenterImpl implements RecentContract.Presenter {

    private RecentContract.View mView;

    public RecentPresenter(RecentContract.View view) {
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
    public void loadMore(int currentPage, int pageSize, int totalRecord, String sortType) {
        if (currentPage > totalRecord / pageSize) {
            mView.showLoading();
            Map<String, String> options = new HashMap<>();
            options.put(SORT, sortType);
            options.put(PAGE, String.valueOf(currentPage));
            options.put(PER_PAGE, String.valueOf(pageSize));
            getShotList(options);
        }
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
                mView.hideLoading();
                mView.showEmptyView();
            }

            @Override
            public void onNext(ShotEntity[] shotEntities) {
                mView.hideLoading();
                mView.showList(shotEntities);
            }
        });
    }

}
