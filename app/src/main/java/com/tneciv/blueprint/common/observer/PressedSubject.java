package com.tneciv.blueprint.common.observer;

/**
 * Created by Tneciv
 * on 2016-09-14 21:44 .
 */

public interface PressedSubject {
    void registerObserver(PressedObserver observer);

    void removeObserver(PressedObserver observer);

    void notifyObservers(BackPressedListener pressedListener);
}
