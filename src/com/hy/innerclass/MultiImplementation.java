package com.hy.innerclass;

/**
 * Created by Hy on 2017/2/21.
 */
class D{
    public D() {
        System.out.println("create D");
    }
}
abstract class E{
    public E() {
        System.out.println("create E");
    }
    public void say(){}
}
class Z extends D{
    public Z() {
        System.out.println("create Z");
    }
    E makeE(){
        return new E() {
            @Override
            public void say() {
                //super.say();
                System.out.println("Mutil extends?");
            }
        };
    }
}
public class MultiImplementation {
    public static void main(String[] args) {
        Z z = new Z();
        z.makeE().say();
    }
}
