package com.tneciv.dribbble.module.recent;

import com.tneciv.dribbble.base.BasePresenterImpl;
import com.tneciv.dribbble.common.ApiServiceFactory;
import com.tneciv.dribbble.common.ShotService;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;

import static com.tneciv.dribbble.common.Constants.PAGE_SIZE;

/**
 * Created by Tneciv
 * on 2016-08-17 18:20 .
 */
public class RecentPresenter extends BasePresenterImpl implements RecentContract.Presenter {

    private RecentContract.View mView;

    public RecentPresenter(RecentContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        HashMap<String, String> options = new HashMap<>();
        options.put("sort", "recent");
        options.put("page", "1");
        options.put("per_page", String.valueOf(PAGE_SIZE));
        getShotList(options);
    }

    @Override
    public void loadMore(int currentPage, int pageSize, int totalRecord) {

        if (currentPage > totalRecord / pageSize) {
            mView.showLoading();
            HashMap<String, String> options = new HashMap<>();
            options.put("sort", "recent");
            options.put("page", String.valueOf(currentPage));
            options.put("per_page", String.valueOf(pageSize));
            getShotList(options);
        }

    }

    @Override
    public void getShotList(Map<String, String> options) {
        ShotService shotService = ApiServiceFactory.getInstance().create(ShotService.class);
        Observable<ShotEntity[]> shotList = shotService.getShotListWithQueryMap(options);
        addSubscription(shotList, new Subscriber<ShotEntity[]>() {
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
