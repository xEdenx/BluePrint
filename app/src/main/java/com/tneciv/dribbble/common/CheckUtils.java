package com.tneciv.dribbble.common;

import android.text.TextUtils;

/**
 * Created by Tneciv
 * on 2016-08-20 22:10 .
 */

public class CheckUtils {
    public static String checkString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "NA";
        } else {
            return str;
        }
    }

    /**
     * http://stackoverflow.com/questions/4972695/crashing-due-to-no-package-identifier-when-getting-value-of-resource-number
     * It's a very very stupid bug of Android .
     */
    public static String checkInteger(int integer) {
        return integer + "";
    }
}
