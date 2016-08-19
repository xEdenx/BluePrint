package com.tneciv.dribbble.module.user;

import com.tneciv.dribbble.base.BasePresenter;
import com.tneciv.dribbble.base.BaseView;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface PopularContract {
    interface View extends BaseView<Presenter> {
        void showResponse(String response);
    }

    interface Presenter extends BasePresenter {
        void unSubscribe();
    }
}
