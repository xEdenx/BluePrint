package com.tneciv.blueprint.module.comments;

import com.tneciv.blueprint.base.BaseRxImpl;
import com.tneciv.blueprint.entity.CommentEntity;
import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.CommentsService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-30 14:47 .
 */

class CommentsPresenter extends BaseRxImpl implements CommentsContract.Presenter {
    private CommentsContract.View mView;

    CommentsPresenter(CommentsContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        super.onUnsubscribe();
    }

    @Override
    public void getComments(int shotId) {
        mView.showLoading();
        CommentsService service = ApiServiceFactory.getInstance().create(CommentsService.class);
        Observable<CommentEntity[]> comments = service.getComments(shotId);
        addSubscription(comments, new Subscriber<CommentEntity[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.handleError(e);
            }

            @Override
            public void onNext(CommentEntity[] commentEntities) {
                mView.hideLoading();
                mView.showResult(commentEntities);
            }
        });
    }
}
