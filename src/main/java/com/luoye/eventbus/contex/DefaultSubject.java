package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

import java.util.LinkedList;
import java.util.List;

public class DefaultSubject implements Subject {
    List<Observer> observerList = new LinkedList<>();

    private String subjectId;

    public void setSubjectId(String subjectId){
        this.subjectId = subjectId;
    }
    public DefaultSubject(String subjectId){
        this.subjectId = subjectId;

    }
    @Override
    public String getSubjectId() {
        return subjectId==null?"null":subjectId;
    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(Event event) {
        for (Observer observer :
                observerList) {
            observer.response(event);
        }
    }
}
