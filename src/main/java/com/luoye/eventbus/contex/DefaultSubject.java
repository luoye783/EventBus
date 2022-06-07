package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

import java.util.LinkedList;
import java.util.List;

public class DefaultSubject<T extends Event> implements Subject<T> {
    List<Observer<T>> observerList = new LinkedList<>();

    private String subjectId;

    public void setSubjectId(String subjectId){
        this.subjectId = subjectId;
    }
    @Override
    public String getSubjectId() {
        return subjectId==null?"null":subjectId;
    }

    @Override
    public void add(Observer<T> observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer<T> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(T event) {
        for (Observer<T> observer :
                observerList) {
            observer.response(event);
        }
    }
}
