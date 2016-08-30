package com.tneciv.blueprint.module.comments;

import com.tneciv.blueprint.base.BasePresenterImpl;

/**
 * Created by Tneciv
 * on 2016-08-30 14:47 .
 */

public class CommentsPresenter extends BasePresenterImpl implements CommentContract.Presenter {
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        super.onUnsubscribe();
    }
}
