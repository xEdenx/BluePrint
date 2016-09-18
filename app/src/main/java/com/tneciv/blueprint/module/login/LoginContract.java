package com.tneciv.blueprint.module.login;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;

/**
 * Created by Tneciv
 * on 2016-09-17 19:00 .
 */

public interface LoginContract {

    interface Presenter extends BasePresenter {
        void login();
    }

    interface View extends BaseView<Presenter> {

    }
}
