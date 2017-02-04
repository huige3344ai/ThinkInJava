package com.hy.reuse;

/**
 * Created by Hy on 2017/1/26.
 */
class Ative{
    Ative(String type){
        System.out.println("A："+type);
    }
}

public class Art extends Ative{
    Art(String type){
        super(type);
        System.out.println("Art:"+type);
    }

    public static void main(String[] args) {
        Art art = new Art("art");
    }
}


