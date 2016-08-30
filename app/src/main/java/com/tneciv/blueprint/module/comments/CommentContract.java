package com.tneciv.blueprint.module.comments;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;

/**
 * Created by Tneciv
 * on 2016-08-30 14:43 .
 */

interface CommentContract {
    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {

    }
}
