package com.tneciv.blueprint.module.other;

import com.tneciv.blueprint.base.BasePresenter;
import com.tneciv.blueprint.base.BaseView;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.Map;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface EmptyContract {
    interface View extends BaseView<Presenter> {
        void showList(ShotEntity[] shotEntities);

        void showEmptyView();
    }

    interface Presenter extends BasePresenter {
        void getShotList(Map<String, String> options);
    }
}
