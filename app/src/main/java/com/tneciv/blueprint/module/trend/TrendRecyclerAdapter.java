package com.tneciv.blueprint.module.trend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseRecyclerAdapter;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.module.shot.ShotActivity;
import com.tneciv.blueprint.widget.CircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.tneciv.blueprint.common.CheckUtils.checkInteger;
import static com.tneciv.blueprint.common.CheckUtils.checkString;
import static com.tneciv.blueprint.common.CheckUtils.friendlyTime;

/**
 * Created by Tneciv
 * on 2016-08-19 15:05 .
 */

class TrendRecyclerAdapter extends BaseRecyclerAdapter<ShotEntity, TrendRecyclerAdapter.ItemViewHolder> {

    TrendRecyclerAdapter(Context context, List<ShotEntity> entities) {
        super(context, entities);
    }

    @Override
    protected void bindItemView(ItemViewHolder holder, int position) {
        ShotEntity entity = dataList.get(position);
        String imageHidpi = entity.getImages().getHidpi();
        String imageNormal = entity.getImages().getNormal();
        String avatarUrl = entity.getUser().getAvatar_url();
        String updatedAt = friendlyTime(entity.getUpdated_at());
        int attachmentsCount = entity.getAttachments_count();

        if (attachmentsCount == 0) {
            holder.attachImg.setVisibility(View.GONE);
            holder.attactCount.setVisibility(View.GONE);
        } else {
            holder.attachImg.setVisibility(View.VISIBLE);
            holder.attactCount.setVisibility(View.VISIBLE);
            holder.attactCount.setText(checkInteger(attachmentsCount));
        }

        holder.title.setText(checkString(entity.getTitle()));
        holder.name.setText(checkString(entity.getUser().getName()));
        holder.updateTime.setText(checkString(updatedAt));
        holder.comments.setText(checkInteger(entity.getComments_count()));
        holder.likes.setText(checkInteger(entity.getLikes_count()));
        holder.views.setText(checkInteger(entity.getViews_count()));
        if (!TextUtils.isEmpty(avatarUrl)) {
            Glide.with(mContext)
                    .load(avatarUrl)
                    .error(R.drawable.dribbble)
                    .transform(new CircleTransform(mContext))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(holder.userAvatar);
        }
        if (!TextUtils.isEmpty(imageNormal)) {
            Glide.with(mContext)
                    .load(TextUtils.isEmpty(imageHidpi) ? imageNormal : imageHidpi)
                    .error(R.drawable.dribbble)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(new GlideDrawableImageViewTarget(holder.shotImageContent, 5));
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflateItemView(R.layout.layout_shot_item, parent);
        return new ItemViewHolder(itemView);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userAvatar)
        ImageView userAvatar;
        @BindView(R.id.shotImageContent)
        ImageView shotImageContent;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.views)
        TextView views;
        @BindView(R.id.likes)
        TextView likes;
        @BindView(R.id.comments)
        TextView comments;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.updateTime)
        TextView updateTime;
        @BindView(R.id.attachImg)
        ImageView attachImg;
        @BindView(R.id.attactCount)
        TextView attactCount;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        void gotoDetail(View view) {
            int position = getLayoutPosition();
            ShotEntity entity = dataList.get(position);
            Intent intent = new Intent(view.getContext(), ShotActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.SHOT_ENTITY, entity);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }

    }

}
