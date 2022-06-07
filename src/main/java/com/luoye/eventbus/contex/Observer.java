package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

public interface Observer<T extends Event> {
    public void response(T event);
}
