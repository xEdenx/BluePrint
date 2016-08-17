package com.tneciv.dribbble.module.shot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tneciv.dribbble.R;
import com.tneciv.dribbble.entity.ShotEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tneciv
 * on 2016-08-17 21:14 .
 */

public class ShotRecyclerAdapter extends RecyclerView.Adapter<ShotRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<ShotEntity> list;

    public ShotRecyclerAdapter(Context context, List<ShotEntity> entities) {
        this.mContext = context;
        this.list = entities;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_item_shot, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShotEntity entity = list.get(position);
        Log.d("adapter", "position: create" + position);
        Spanned spanned = Html.fromHtml(entity.getDescription() + "");
        holder.result.setText(spanned);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.result)
        TextView result;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
