package com.hy.innerclass;

import java.util.ArrayList;

/**
 * Created by Hy on 2017/3/2.
 */
public class Contoller {
    private ArrayList<Event> eventArrayList = new ArrayList<>();
    public void addEvent(Event event){
        eventArrayList.add(event);
    }
    public void run(){
        while (eventArrayList.size()>0){
            eventArrayList.forEach(
                    event -> {
                        if (event.ready()){
                            event.action();
                            System.out.println("Off "+event.toString());
                            eventArrayList.remove(event);
                        }
                    }
            );

        }
    }
}
