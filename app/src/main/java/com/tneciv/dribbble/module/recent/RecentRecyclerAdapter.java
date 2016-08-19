package com.tneciv.dribbble.module.recent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.base.BaseRecyclerAdapter;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        Spanned spanned = Html.fromHtml(entity.getDescription() + "");
        holder.result.setText(spanned);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflateItemView(R.layout.layout_item_shot, parent);
        return new ItemViewHolder(itemView);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.result)
        TextView result;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
