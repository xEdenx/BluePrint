package com.tneciv.blueprint.module.shot;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;
import com.tneciv.blueprint.entity.ShotEntity;

/**
 * Created by Tneciv
 * on 2016-08-23 21:40 .
 */

interface ShotContract {
    interface Presenter extends BasePresenter {
        void loadData(int id);
    }

    interface View extends BaseView<Presenter> {
        void showResult(ShotEntity entity);
    }
}
