package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

public interface Observer {
    public void response(Event event);
}
