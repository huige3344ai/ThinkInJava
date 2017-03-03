package com.hy.innerclass;

/**
 * Created by Hy on 2017/2/21.
 */

interface Outside2{
    default void play(){
        System.out.printf("Outside");
    }
    String say();
    class Nested {
        public static void saySomething(Outside2 outside2){
            outside2.play();
            System.out.println(outside2.say());
        }
    }
}
public class Ex21 implements Outside2 {
    @Override
    public String say() {
        return "Ex21";
    }

    public static void main(String[] args) {
        Nested nested =  new Nested();
        nested.saySomething(new Ex21());
    }
}
