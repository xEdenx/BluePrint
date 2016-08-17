package com.tneciv.dribbble.module.main;

import com.tneciv.dribbble.base.BasePresenter;
import com.tneciv.dribbble.base.BaseView;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        void showResponse(String response);
    }

    interface Presenter extends BasePresenter {
        void unSubscribe();
    }
}
