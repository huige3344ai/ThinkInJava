package com.hy.innerclass;

/**
 * Created by Hy on 2017/3/2.
 */
public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls greenHouseControls = new GreenHouseControls();
        Event[] events = {
                greenHouseControls.new Fan(120)
        };

        if (args.length==1){
            greenHouseControls.addEvent(new GreenHouseControls.Terminate(new Integer(args[0]),events));
        }

    }
}
