package com.tneciv.blueprint.module.comments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseRecyclerAdapter;
import com.tneciv.blueprint.entity.CommentEntity;

import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-21 23:18 .
 */

public class CommentsAdapter extends BaseRecyclerAdapter<CommentEntity, CommentsAdapter.CommentsViewHolder> {

    CommentsAdapter(Context context, List<CommentEntity> entities) {
        super(context, entities);
    }

    @Override
    protected void bindItemView(CommentsViewHolder holder, int position) {
        CommentEntity entity = dataList.get(position);
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflateItemView(R.layout.layout_comment_item, parent);
        return new CommentsViewHolder(view);
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder {

        CommentsViewHolder(View itemView) {
            super(itemView);
        }
    }

}
