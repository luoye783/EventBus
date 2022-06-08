package com.luoye.eventbus.contex;

import com.luoye.eventbus.bus.Event;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class BusContext {
    static Map<String, DefaultSubject> subjectMap = new ConcurrentHashMap<>();
    static BlockingQueue<Event> blockingQueue = new LinkedBlockingQueue<>();

    public static void pushEvent(Event event) {
        blockingQueue.offer(event);
    }

    protected static void startListening() {
        while (true) {
            try {
                Event event = blockingQueue.take();
                subjectMap.get(event.getSubjectId()).notifyObserver(event);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        Map<String, DefaultSubject> subjectMap = new ConcurrentHashMap<>();
        subjectMap.put("1", new DefaultSubject("13") {
        });
        String subjectId = subjectMap.get("1").getSubjectId();
        System.out.println(subjectId);

    }
}
