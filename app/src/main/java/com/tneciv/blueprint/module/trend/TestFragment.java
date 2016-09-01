package com.tneciv.blueprint.module.trend;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tneciv.blueprint.common.Constants;

import java.util.Map;

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
        return defaultOptionMap(Constants.SORT, Constants.SORT_TYPE_RECENT);
    }
}
