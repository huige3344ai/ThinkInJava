package com.hy.innerclass;


import java.util.List;

public class GreenHouseControls extends Contoller {
    /**
     * Created by Hy on 2017/3/2.
     */
    public class Fan extends Event{
        public Fan(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("Fan is on");
        }

        @Override
        public String toString() {
            return "Fan";
        }
    }

    public class Fan2 extends Event{
        public Fan2(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("Fan2 is on");
        }

        @Override
        public String toString() {
            return "Fan2";
        }
    }

    public class Restart extends Event{
        private List<Event> events;
        public Restart(long delayTime,List<Event> events) {
            super(delayTime);
            this.events=events;
            this.events.forEach(event->addEvent(event));

        }

        @Override
        public void action() {
            events.forEach(event -> {
                System.out.println("Restarting");
                System.out.println(event.toString());
                event.start();
                addEvent(event);
            });
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart";
        }
    }

    public static class Terminate extends Event{
        private List<Event>  events;
        public Terminate(long delayTime,List<Event> events) {
            super(delayTime);
            this.events=events;
        }

        @Override
        public void action() {
            System.out.println("Terminate");
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminate";
        }
    }
}
