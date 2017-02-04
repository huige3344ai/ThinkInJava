package com.hy.reuse;

import java.lang.reflect.Type;

/**
 * Created by Hy on 2017/1/26.
 */
class Seven{
    Seven(String type){
        System.out.println("Seven:"+ type);
    }
}
public class Exercise7 extends Seven {
    Exercise7(){
        super("default");
        System.out.println("E7 default");
    }
    Exercise7(String type){
        super(type);
        System.out.println("E7:"+type);
    }
    public static void main(String[] args) {
        new Exercise7();
        new Exercise7("Exercise7");
    }
}
