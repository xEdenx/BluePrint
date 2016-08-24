package com.tneciv.blueprint;

/**
 * Created by Tneciv
 * on 2016-08-14 15:58 .
 * MVP 中 View
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
