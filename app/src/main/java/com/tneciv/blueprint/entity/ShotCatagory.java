package com.tneciv.blueprint.entity;

/**
 * Created by Tneciv
 * on 2016-09-01 15:59 .
 * wanna get values by @annoation
 */

public class ShotCatagory {

    public enum Name {
        LIST,
        TIMEFRAME,
        SORT
    }

    public enum List {
        ANIMATED,
        ATTACHMENTS,
        DEBUTS,
        PLAYOFFS,
        REBOUNDS,
        TEAMS
    }

    public enum Timeframe {
        WEEK,
        MONTH,
        YEAR,
        EVER
    }

    public enum Sort {
        COMMENTS,
        RECENTS,
        VIEWS
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
            case ANIMATED:
                return "animated";
            case DEBUTS:
                return "debuts";
            case TEAMS:
                return "teams";
            case REBOUNDS:
                return "rebounds";
            case PLAYOFFS:
                return "playoffs";
            case ATTACHMENTS:
                return "attachments";
            default:
                return "";
        }
    }

    public static String getShotsType(Timeframe timeframe) {
        switch (timeframe) {
            case WEEK:
                return "week";
            case EVER:
                return "ever";
            case MONTH:
                return "month";
            case YEAR:
                return "year";
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
