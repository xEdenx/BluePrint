package com.tneciv.widget;

import android.content.Context;

/**
 * Created by Tneciv
 * on 2016-08-28 11:28 .
 */

public class Tool {

    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Context context, float sp) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

}
