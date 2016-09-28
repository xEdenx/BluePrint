package com.tneciv.blueprint.common.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tneciv
 * on 2016-08-20 22:10 .
 */

public class CheckUtils {

    public static String checkString(String str) {
        return TextUtils.isEmpty(str) ? str + "" : str;
    }

    /**
     * http://stackoverflow.com/questions/4972695/crashing-due-to-no-package-identifier-when-getting-value-of-resource-number
     */
    public static String checkInteger(int integer) {
        return integer + "";
    }

    public static String convert2LocalTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output.format(d);
    }

    public static String friendlyTime(String date) {
        String s = convert2LocalTime(date);
        Date time = toDate(s);
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        // is Same day
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0) {
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1) + " minutes ago";
            } else {
                ftime = hour + " hours ago";
            }
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0) {
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1) + " minutes ago";
            } else {
                ftime = hour + " hours ago";
            }
        } else if (days == 1) {
            ftime = "yesterday";
        } else if (days == 2) {
            ftime = "2 days ago";
        } else if (days > 2 && days <= 10) {
            ftime = days + " days ago";
        } else if (days > 10) {
            ftime = dateFormater2.get().format(time);
        }
        return ftime;
    }

    private static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

}
