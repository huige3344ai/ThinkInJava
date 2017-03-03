package com.hy.innerclass;


public class GreenHouseControls extends Contoller {
    /**
     * Created by Hy on 2017/3/2.
     */
    private String fan = "Fan";
    public class Fan extends Event{

        public Fan(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = "Fan is on";
        }

        @Override
        public String toString() {
            return fan;
        }
    }
    public class Restart extends Event{
        private Event[] events;
        public Restart(long delayTime,Event[] events) {
            super(delayTime);
            this.events=events;
            for (Event event:events) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event: events
                 ) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public static class Terminate extends Event{
        private Event[] events;
        public Terminate(long delayTime,Event[] events) {
            super(delayTime);
            this.events=events;
        }

        @Override
        public void action() {
            for (Event event:
                 events) {
                event.stop();
            }
            System.exit(0);
        }
    }
}
