package com.hy.innerclass.one;

/**
 * Created by Hy on 2017/2/6.
 */
public interface One {
    void say();
    //jdk1.8 key word :default
//    default  void play();//must be have body.
    default void fuck(){
        System.out.println("fuck");
    }
    //jdk1.8 support static method.
//    static  void fuck2();//must be have body.
    static void fuck2(){
        System.out.println("fuck2");
    }

}
