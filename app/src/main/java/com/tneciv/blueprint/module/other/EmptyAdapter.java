package com.tneciv.blueprint.module.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.entity.ShotEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tneciv.blueprint.common.CheckUtils.checkInteger;
import static com.tneciv.blueprint.common.CheckUtils.checkString;
import static com.tneciv.blueprint.common.CheckUtils.convert2LocalTime;
import static com.tneciv.blueprint.common.CheckUtils.friendlyTime;

/**
 * Created by Tneciv
 * on 2016-08-21 23:18 .
 */

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {

    public List<ShotEntity> list;
    private Context mContext;

    public EmptyAdapter(Context context, List<ShotEntity> attractions) {
        super();
        mContext = context;
        list = attractions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_shot_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShotEntity entity = list.get(position);
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

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
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

    }

}
