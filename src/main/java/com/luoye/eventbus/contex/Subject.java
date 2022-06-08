package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

public interface Subject {
    String getSubjectId();
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObserver(Event event);
}
