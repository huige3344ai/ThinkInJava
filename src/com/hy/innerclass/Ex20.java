package com.hy.innerclass;

/**
 * Created by Hy on 2017/2/21.
 */
interface Outside{
    default void play(){
        System.out.printf("Outside");
    }
    static class Nested implements Outside {
        @Override
        public void play() {
            System.out.printf("Nested");
        }
    }
}
public class Ex20 {
    public static void main(String[] args) {
        Outside outside = new Outside.Nested();
        outside.play();
    }
}

