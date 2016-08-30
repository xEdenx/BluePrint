package com.tneciv.blueprint.module.comments;

import com.tneciv.blueprint.BasePresenter;
import com.tneciv.blueprint.BaseView;
import com.tneciv.blueprint.entity.CommentEntity;

/**
 * Created by Tneciv
 * on 2016-08-30 14:43 .
 */

interface CommentsContract {
    interface Presenter extends BasePresenter {
        void getComments(int shotId);
    }

    interface View extends BaseView<Presenter> {
        void showLoading();

        void hideLoading();

        void showResult(CommentEntity[] entities);

        void handleError(Throwable e);
    }
}
