package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

public interface Subject<T extends Event> {
    String getSubjectId();
    void add(Observer<T> observer);
    void remove(Observer<T> observer);
    void notifyObserver(T event);
}
