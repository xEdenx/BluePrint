package com.tneciv.blueprint.module.recent;

import com.tneciv.blueprint.base.BasePresenter;
import com.tneciv.blueprint.base.BaseView;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.Map;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface RecentContract {
    interface View extends BaseView<Presenter> {
        void showList(ShotEntity[] shotEntities);

        void showLoading();

        void hideLoading();

        void showEmptyView();
    }

    interface Presenter extends BasePresenter {
        void loadMore(int currentPage, int pageSize, int totalRecord, String sortType);

        void getShotList(Map<String, String> options);

    }
}
