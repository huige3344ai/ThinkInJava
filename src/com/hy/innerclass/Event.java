package com.hy.innerclass;

abstract class Event {
    private long eventTime;
    private final long delayTime;
    public Event(long delayTime){
        this.delayTime=delayTime;
        start();
    }

    public void start(){
        eventTime=System.nanoTime()+delayTime;
    }

    public  boolean ready(){
        if (eventTime>0&&System.nanoTime()>=eventTime) return true;
        return false;
    }

    public abstract void action();

}
