package com.tneciv.blueprint.module.popular;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;

/**
 * Created by Tneciv
 * on 2016-08-14 16:00 .
 */

interface PopularContract {
    interface View extends BaseView<Presenter> {
        void showResponse(String response);
    }

    interface Presenter extends BasePresenter {
    }
}
