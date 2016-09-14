package com.tneciv.blueprint.common.observer;

import android.os.Parcelable;

/**
 * Created by Tneciv
 * on 2016-09-14 21:44 .
 */

public interface PressedSubject extends Parcelable {
    void registerObserver(PressedObserver observer);

    void removeObserver(PressedObserver observer);

    void notifyObservers();
}
