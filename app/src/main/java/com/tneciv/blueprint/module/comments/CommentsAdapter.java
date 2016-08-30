package com.tneciv.blueprint.module.comments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseRecyclerAdapter;
import com.tneciv.blueprint.common.CheckUtils;
import com.tneciv.blueprint.entity.CommentEntity;
import com.tneciv.blueprint.widget.CircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.commentsContent.setText(Html.fromHtml(entity.getBody()));
        holder.createTime.setText(CheckUtils.friendlyTime(entity.getCreated_at()));
        holder.name.setText(entity.getUser().getName());
        Glide.with(mContext)
                .load(entity.getUser().getAvatar_url())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new CircleTransform(mContext))
                .into(holder.avatr);
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflateItemView(R.layout.layout_comment_item, parent);
        return new CommentsViewHolder(view);
    }

    static class CommentsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatr)
        ImageView avatr;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.createTime)
        TextView createTime;
        @BindView(R.id.commentsContent)
        TextView commentsContent;

        CommentsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
