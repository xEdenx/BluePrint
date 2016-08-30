package com.tneciv.blueprint.module.comments;

import com.tneciv.blueprint.base.BasePresenterImpl;
import com.tneciv.blueprint.entity.CommentEntity;
import com.tneciv.blueprint.retrofit.ApiServiceFactory;
import com.tneciv.blueprint.retrofit.CommentsService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Tneciv
 * on 2016-08-30 14:47 .
 */

public class CommentsPresenter extends BasePresenterImpl implements CommentContract.Presenter {
    private CommentContract.View mView;

    public CommentsPresenter(CommentContract.View mView) {
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
            }

            @Override
            public void onNext(CommentEntity[] commentEntities) {
                mView.hideLoading();
                mView.showResult(commentEntities);
            }
        });
    }
}
