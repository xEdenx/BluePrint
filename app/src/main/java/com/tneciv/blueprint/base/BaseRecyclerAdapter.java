package com.tneciv.blueprint.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-19 15:02 .
 */

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    private LayoutInflater mInflater;
    public List<T> dataList;
    private PaginationListener mListener;
    public Fragment mFragment;

    public BaseRecyclerAdapter(Fragment fragment, List<T> entities) {
        this.mFragment = fragment;
        this.mContext = fragment.getContext();
        this.dataList = entities;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected abstract void bindItemView(VH holder, int position);

    protected View inflateItemView(@LayoutRes int itemLayout, ViewGroup parent) {
        return mInflater.inflate(itemLayout, parent, false);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        bindItemView(holder, position);
        if (mListener != null) {
            mListener.onChange(position + 1);
        }
    }

    public void addPaginationListener(PaginationListener listener) {
        this.mListener = listener;
    }

    public void removePaginationListener() {
        this.mInflater = null;
        this.mContext = null;
        this.mListener = null;
        this.mFragment = null;
    }

    @FunctionalInterface
    public interface PaginationListener {
        void onChange(int position);
    }

}
