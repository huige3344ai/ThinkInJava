package com.hy.innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hy on 2017/3/2.
 */
public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        List<Event> events = new ArrayList<Event>();
        events.add( gc.new Fan(1000));
        events.add( gc.new Fan2(2000));


        gc.addEvent(gc.new Restart(4000,events));

        gc.addEvent(new GreenHouseControls.Terminate(5000,events));

        gc.run();

    }
}
