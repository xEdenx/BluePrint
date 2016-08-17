package com.tneciv.dribbble.module.shot;

import com.tneciv.dribbble.base.BasePresenter;
import com.tneciv.dribbble.base.BaseView;
import com.tneciv.dribbble.entity.ShotEntity;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

public interface ShotContract {
    interface View extends BaseView<Presenter> {
        void showList(ShotEntity[] shotEntities);
    }

    interface Presenter extends BasePresenter {
    }
}
