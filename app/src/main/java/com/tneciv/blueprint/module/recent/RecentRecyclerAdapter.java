package com.tneciv.blueprint.module.recent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.base.BaseRecyclerAdapter;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.widget.CircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tneciv.blueprint.common.CheckUtils.checkInteger;
import static com.tneciv.blueprint.common.CheckUtils.checkString;
import static com.tneciv.blueprint.common.CheckUtils.convert2LocalTime;
import static com.tneciv.blueprint.common.CheckUtils.friendlyTime;

/**
 * Created by Tneciv
 * on 2016-08-19 15:05 .
 */

class RecentRecyclerAdapter extends BaseRecyclerAdapter<ShotEntity, RecentRecyclerAdapter.ItemViewHolder> {

    RecentRecyclerAdapter(Context context, List<ShotEntity> entities) {
        super(context, entities);
    }

    @Override
    protected void bindItemView(ItemViewHolder holder, int position) {
        ShotEntity entity = dataList.get(position);
        String imageHidpi = entity.getImages().getHidpi();
        String imageNormal = entity.getImages().getNormal();
        String avatarUrl = entity.getUser().getAvatar_url();
        String updatedAt = convert2LocalTime(entity.getUpdated_at());
        updatedAt = friendlyTime(updatedAt);
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
            Picasso.with(mContext).load(avatarUrl).transform(new CircleTransform()).into(holder.userAvatar);
        }
        if (!TextUtils.isEmpty(imageNormal)) {
            Picasso.with(mContext).load(TextUtils.isEmpty(imageHidpi) ? imageNormal : imageHidpi).into(holder.shotImageContent);
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
    }

}
