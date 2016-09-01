package com.tneciv.blueprint.entity;

/**
 * Created by Tneciv
 * on 2016-09-01 15:59 .
 */

public class Catagory {
    enum ShotCatagory {
        LIST, TIMEFRAME, SORT;
    }

    enum ListCatagory {
        animated
    }

    enum TimeframeCatagory {
        WEEK, MONTH, YEAR, EVER
    }

    enum SortCatagory {
        COMMENTS, RECENTS, VIEWS
    }
}
