package com.tneciv.blueprint.entity;

/**
 * Created by Tneciv
 * on 2016-09-01 15:59 .
 * wanna get values by @annoation
 */

public class ShotCatagory {

    public enum Name {
        LIST, TIMEFRAME, SORT
    }

    public enum List {
        animated
    }

    public enum Timeframe {
        WEEK, MONTH, YEAR, EVER
    }

    public enum Sort {
        COMMENTS, RECENTS, VIEWS
    }

    public static String getShotsName(Name name) {
        switch (name) {
            case LIST:
                return "list";
            case SORT:
                return "sort";
            case TIMEFRAME:
                return "timeframe";
            default:
                return "";
        }
    }

    public static String getShotsType(List list) {
        switch (list) {
            case animated:
                return "animated";
            default:
                return "";
        }
    }

    public static String getShotsType(Timeframe timeframe) {
        switch (timeframe) {
            case WEEK:
                return "week";
            default:
                return "";
        }
    }

    public static String getShotsType(Sort sort) {
        switch (sort) {
            case COMMENTS:
                return "comments";
            case RECENTS:
                return "recent";
            case VIEWS:
                return "views";
            default:
                return "";
        }
    }

}
