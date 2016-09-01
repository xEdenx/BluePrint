package com.tneciv.blueprint.module.trend;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tneciv.blueprint.entity.ShotCatagory;

import java.util.Map;

import static com.tneciv.blueprint.entity.ShotCatagory.getShotsName;
import static com.tneciv.blueprint.entity.ShotCatagory.getShotsType;

/**
 * Created by Tneciv
 * on 2016-09-01 15:02 .
 */

public class TestFragment extends TrendFragment {


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
        return setOptionType(getShotsName(ShotCatagory.Name.SORT), getShotsType(ShotCatagory.Sort.RECENTS));
    }
}
