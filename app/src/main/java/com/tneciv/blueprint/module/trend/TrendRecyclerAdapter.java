package com.tneciv.blueprint.module.trend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import static com.tneciv.blueprint.common.utils.CheckUtils.checkInteger;
import static com.tneciv.blueprint.common.utils.CheckUtils.checkString;
import static com.tneciv.blueprint.common.utils.CheckUtils.friendlyTime;
import static com.tneciv.blueprint.entity.ViewHolderType.RECENT;
import static com.tneciv.blueprint.entity.ViewHolderType.VIEW;

/**
 * Created by Tneciv
 * on 2016-08-19 15:05 .
 */

class TrendRecyclerAdapter extends BaseRecyclerAdapter<ShotEntity, RecyclerView.ViewHolder> {

    TrendRecyclerAdapter(Fragment fragment, List<ShotEntity> entities) {
        super(fragment, entities);
    }

    @Override
    protected void bindItemView(RecyclerView.ViewHolder holder, int position) {
        ShotEntity entity = dataList.get(position);
        String imageHidpi = entity.getImages().getHidpi();
        String imageNormal = entity.getImages().getNormal();
        String avatarUrl = entity.getUser().getAvatar_url();
        String updatedAt = friendlyTime(entity.getUpdated_at());
        int attachmentsCount = entity.getAttachments_count();

        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            if (attachmentsCount == 0) {
                viewHolder.attachImg.setVisibility(View.GONE);
                viewHolder.attactCount.setVisibility(View.GONE);
            } else {
                viewHolder.attachImg.setVisibility(View.VISIBLE);
                viewHolder.attactCount.setVisibility(View.VISIBLE);
                viewHolder.attactCount.setText(checkInteger(attachmentsCount));
            }

            viewHolder.title.setText(checkString(entity.getTitle()));
            viewHolder.name.setText(checkString(entity.getUser().getName()));
            viewHolder.updateTime.setText(checkString(updatedAt));
            viewHolder.comments.setText(checkInteger(entity.getComments_count()));
            viewHolder.likes.setText(checkInteger(entity.getLikes_count()));
            viewHolder.views.setText(checkInteger(entity.getViews_count()));
            if (!TextUtils.isEmpty(avatarUrl)) {
                Glide.with(mFragment)
                        .load(avatarUrl)
                        .placeholder(R.drawable.dribbble)
                        .error(R.drawable.dribbble)
                        .transform(new CircleTransform(mContext))
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(viewHolder.userAvatar);
            }
            if (!TextUtils.isEmpty(imageNormal)) {
                Glide.with(mFragment)
                        .load(TextUtils.isEmpty(imageHidpi) ? imageNormal : imageHidpi)
                        .placeholder(R.drawable.ic_error_light)
                        .error(R.drawable.ic_error_light)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(new GlideDrawableImageViewTarget(viewHolder.shotImageContent, 5));
            }
        }

        if (holder instanceof RecentHolder) {
            RecentHolder recentHolder = (RecentHolder) holder;
            if (!TextUtils.isEmpty(imageNormal)) {
                Glide.with(mFragment)
                        .load(TextUtils.isEmpty(imageHidpi) ? imageNormal : imageHidpi)
                        .placeholder(R.drawable.ic_error_light)
                        .error(R.drawable.ic_error_light)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(new GlideDrawableImageViewTarget(recentHolder.imgContent, 5));
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW.ordinal()) {
            View itemView = inflateItemView(R.layout.layout_view_item, parent);
            return new ViewHolder(itemView);
        }

        if (viewType == RECENT.ordinal()) {
            View itemView = inflateItemView(R.layout.layout_recent_item, parent);
            return new RecentHolder(itemView);
        }

        return null;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

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

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        void gotoDetail(View view) {
            goToDetail(view, this);
        }

    }

    class RecentHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgContent)
        ImageView imgContent;

        RecentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.imgContent)
        void onClick(View view) {
            goToDetail(view, this);
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (mFragment instanceof ViewFragment) {
            return VIEW.ordinal();
        }

        if (mFragment instanceof RecentFragment) {
            return RECENT.ordinal();
        }

        return super.getItemViewType(position);
    }

    private void goToDetail(View view, RecyclerView.ViewHolder viewHolder) {
        int position = viewHolder.getLayoutPosition();
        ShotEntity entity = dataList.get(position);
        Intent intent = new Intent(view.getContext(), ShotActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.SHOT_ENTITY, entity);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
    }

}
