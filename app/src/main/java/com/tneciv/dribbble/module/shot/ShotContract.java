package com.tneciv.dribbble.module.shot;

import com.tneciv.dribbble.base.BasePresenter;
import com.tneciv.dribbble.base.BaseView;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.Map;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface ShotContract {
    interface View extends BaseView<Presenter> {
        void showList(ShotEntity[] shotEntities);

        void showLoading();

        void hideLoading();
    }

    interface Presenter extends BasePresenter {
        void loadMore(int position, int currentPage, int pageSize, int totalRecord);

        void getShotList(Map<String, String> options);
    }
}
