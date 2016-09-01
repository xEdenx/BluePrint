package com.tneciv.blueprint.module.trend;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tneciv.blueprint.entity.ShotCatagory;

import java.util.Map;

import static com.tneciv.blueprint.entity.ShotCatagory.getShotsName;
import static com.tneciv.blueprint.entity.ShotCatagory.getShotsType;


public class ViewFragment extends TrendFragment {

    @Override
    protected Fragment setViewType() {
        return this;
    }

    @Override
    public RecyclerView.LayoutManager setLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public Map<String, String> initOptionMap() {
        return defaultOptionMap();
    }

    @Override
    public Map<String, String> setOptionType() {
        return setOptionType(getShotsName(ShotCatagory.Name.SORT), getShotsType(ShotCatagory.Sort.VIEWS));
    }
}
