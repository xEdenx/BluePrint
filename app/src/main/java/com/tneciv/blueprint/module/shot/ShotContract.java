package com.tneciv.blueprint.module.shot;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;

/**
 * Created by Tneciv
 * on 2016-08-23 21:40 .
 */

public interface ShotContract {
    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {

    }
}
